import java.util.*;
import java.io.*;
public class Student implements Serializable {
	private String firstName; 
    private String birthYear; 
    private String yearInCollege;
    private String cwid;
    private static String binary;
    private static Student deserialStudent;
    
    
	public Student(String firstName, String birthYear, String yearInCollege, String cwid) { 
	        this.firstName = firstName; 
	        this.birthYear = birthYear;
	        this.yearInCollege = yearInCollege;
	        this.cwid = cwid;
	}
	
	public static boolean serializeToBinary(Serializable student) {
		try {
			ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
			ObjectOutputStream objOutStream = new ObjectOutputStream(byteOutStream);
			objOutStream.writeObject(student);
			binary = Base64.getEncoder().encodeToString(byteOutStream.toByteArray());
			objOutStream.close();
		}
		catch (IOException ex) {
			System.out.println("I/O Exception");
			return false;
		}
		
		return true;
	}
	
	public static boolean deserializeBinary(String binary) {
		try {
			byte[] decode = Base64.getDecoder().decode(binary);
			ByteArrayInputStream byteInStream = new ByteArrayInputStream(decode);
			ObjectInputStream objInStream = new ObjectInputStream(byteInStream);
			deserialStudent = (Student)objInStream.readObject();
			objInStream.close();
		}
		catch (IOException ex) {
			System.out.println("I/O Exception");
			return false;
		}
		catch (ClassNotFoundException ex) {
			System.out.println("Class Not Found Exception");
			return false;
		}
		return true;
	}
	
	public static void printStudent(Student student) {
		System.out.println("Name: " + student.firstName +
							"\nBirth Year: " + student.birthYear +
							"\nYear in College: " + student.yearInCollege +
							"\nCWID: " + student.cwid);
	}
	
	public static void main(String[] args) {
		Student stu = new Student("jack", "1997" , "2", "12221333");
		serializeToBinary(stu);
		System.out.println(binary);
		deserializeBinary(binary);
		printStudent(deserialStudent);
	}
}
