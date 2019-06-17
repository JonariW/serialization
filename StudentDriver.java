
public class StudentDriver extends Student{
	
	public StudentDriver(String firstName, String birthYear, String yearInCollege, String cwid) {
		super(firstName, birthYear, yearInCollege, cwid);
	}
	
	@Override
	public boolean equals(Object student) {
		if(student == null || getClass() != student.getClass()) {
			return false;
		}
		else {
			Student otherStudent = (Student) student;
			return firstName == otherStudent.firstName && 
				   birthYear == otherStudent.birthYear &&
				   yearsInCollege == otherStudent.yearsInCollege &&
				   cwid == otherStudent.cwid;
		}
		
	}
	
	public static void main(String[] args) {
		Student stu = new Student("jack", "1997" , "2", "12221333");
		Student stu2 = new Student("john", "1998" , "3", "32225333");
		serializeToBinary(stu);
		System.out.println(binaryNumber);
		deserializeBinary(binaryNumber);
		printStudent(deserializedBinaryStudent);
		System.out.println("Are these the same student? " + stu.equals(deserializedBinaryStudent));
		serializeXML("student.xml", stu2);
		//deserializeXML("student.xml");
		//System.out.println(deserializedXMLStudent);
		printStudent(deserializedXMLStudent);
	}
	
}
