package confirm06;

public class Member {
	String name;
	String id;
	String password;
	int age;

	public Member() {
		// TODO Auto-generated constructor stub
	} // ctrl space: 자동으로 생성자 만들어줌

	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}//힙에 저장 
	
	public static void main(String[] args) {
		Member user1 = new Member("홍길동","hong");
		System.out.println("이름:" + user1.name + " 아이디:" +user1.id);
	} //실행. 스택에 저장 
}
