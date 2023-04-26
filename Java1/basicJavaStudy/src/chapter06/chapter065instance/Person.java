package chapter06.chapter065instance;

public class Person {
	final String nation = "Korean";
//	final String ssn; 값 초기화 필요
	final String ssn;
	String name;
	
	public Person(String ssn, String name) {
		this.ssn = ssn;
		this.name = name;
	}
}
