
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
			return firstName.equals(otherStudent.firstName) && 
					birthYear.equals(otherStudent.birthYear) &&
					yearInCollege.equals(otherStudent.yearInCollege) &&
					cwid.equals(otherStudent.cwid);
		}
	}
	
	public static void main(String[] args) {
		Student stu = new Student("jack", "1997" , "2", "12221333");
		serializeToBinary(stu);
		System.out.println(binary);
		deserializeBinary(binary);
		printStudent(deserialStudent);
	}
	
}
