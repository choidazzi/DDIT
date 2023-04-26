package Exercise.Exercise230329;

public class Student extends Human{
	//field
	private String major; //전공 
	//constructor
	public Student(String name, int age, String major) {
		super(name,age);
		this.major = major;
	}
	//method 
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	@Override
	public String toString() {
		return super.toString() + ", 전공: " + major;
	}
	
}
