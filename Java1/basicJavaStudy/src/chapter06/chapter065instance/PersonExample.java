package chapter06.chapter065instance;

public class PersonExample {
	public static void main(String[] args) {
		Person person = new Person("1234","최서연");
		Person p1 = new Person("1234","최서연");
		Person p2 = new Person("2345","박서연");
		
		System.out.println(p1.ssn);
		System.out.println(p2.ssn);
		
//		person.nation = "US"; error  
//		person.ssn = "1111";  error 
		//final 이 붙어있기 때문에 더이상 값을 할당할 수 없음
		System.out.println(person.nation);
		
		
	}
}
