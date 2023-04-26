package confirm06;

public class Korean {
	String nation = "대한민국";
	String name;
	String ssn; // 주민등록번호  
	//객체가 생성될 때 호출 
	int age;
	
	public Korean() {
		this(null, null,0); //this(null,null) 도 됨.  
	}
	
	public Korean(String name) {
		this(name,null,0); 
	}
	/**
	 * 이름과 주민등록번호를 입력받아 객체 생성
	 *@param name : 이름을 저장
	 *@param ssn : 주민등록번호 저장
	 */
	public Korean(String name, String ssn) {
		this(name,ssn,0); 
	}
	
	public Korean(String name, String ssn , int age) {
		this.name = name; //넣어준 데이터로 초기화
		this.ssn = ssn; //this 자기자신의 객체 주소. 
		this.age = age;
		System.out.println("한국사람이 태어났습니다.");
	}
}
