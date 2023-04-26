package chapter06;

public class objectExample {
	public static void main(String[] args) {
		//instance화 한다. => 객체에 메모리를 만든다.
		//하나의 정의된 클래스로 여러개를 만든다. 데이터 저장을 위해 
		Member member1 = new Member();
		member1.id = "a001";
		member1.password = "asdfasdf";
		member1.hp = "010-1234-5678";
		member1.email = "abc@gmail.com";
		
		Member member2 = new Member();
		member1.id = "b001";
		member1.password = "asdf";
		member1.hp = "010-1234-5678";
		member1.email = "abcdd@gmail.com";
	}
}
