import java.util.*;
import java.beans.*;
import java.io.*;
public class Student implements Serializable {
	
	protected String firstName; 
    protected String birthYear; 
    protected String yearsInCollege;
    protected String cwid;
    protected static String binaryNumber;
    protected static Student deserializedBinaryStudent;
    protected static Student deserializedXMLStudent;
    
    
	public Student(String firstName, String birthYear, String yearsInCollege, String cwid) { 
	        this.firstName = firstName; 
	        this.birthYear = birthYear;
	        this.yearsInCollege = yearsInCollege;
	        this.cwid = cwid;
	}
	
	public static boolean serializeToBinary(Serializable student) {
		try {
			ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
			ObjectOutputStream objOutStream = new ObjectOutputStream(byteOutStream);
			objOutStream.writeObject(student);
			binaryNumber = Base64.getEncoder().encodeToString(byteOutStream.toByteArray());
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
			deserializedBinaryStudent = (Student)objInStream.readObject();
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
							"\nYears in College: " + student.yearsInCollege +
							"\nCWID: " + student.cwid);
	}
	
	public static boolean serializeXML(String file, Student student) {
		XMLEncoder encode = null;
		try {
			FileOutputStream fileOutStream = new FileOutputStream(file);
			encode = new XMLEncoder(new BufferedOutputStream(fileOutStream));
		}
		catch (FileNotFoundException ex) {
			System.out.println("File Entered Not Found");
			return false;
		}
		encode.writeObject(student);
		encode.close();
		return true;
	}
	
	public static boolean deserializeXML(String file) {
		try {
			FileInputStream fileInStream = new FileInputStream(file);
			XMLDecoder decode = new XMLDecoder(fileInStream);
			deserializedXMLStudent = (Student) decode.readObject();
			decode.close();
		}
		catch (FileNotFoundException ex) {
			System.out.println("File Not Found");
			return false;
		}
		return true;
	}
}
