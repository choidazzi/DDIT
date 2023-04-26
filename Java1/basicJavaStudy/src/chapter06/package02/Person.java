package chapter06.package02;

//Java Beans Pattern => 가장 많이 사용 
//: 매개변수가 없는 생성자로 객체를 만든 후 세터(setter) 메서드들을 호출해 원하는 매개변수의 값을 설정하는 방식
//Getter & Setter method 
public class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
