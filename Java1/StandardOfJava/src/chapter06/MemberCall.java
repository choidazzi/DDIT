package chapter06;

public class MemberCall {
	int iv =10;
	static int cv = 20; //class variable
	
	int iv2 = cv;
//	static int cv2 = iv;//class variable 은 인스턴스 변수를 사용 불가 
	static int cv2 = new MemberCall().iv; //객체생성 => 사용가능 
	
	static void staticMethod() {
		System.out.println(cv);
//		System.out.println(iv); //클래스(static) 메소드 안에서 인스턴스 변수 사용 불가 
		MemberCall c = new MemberCall();
		System.out.println(c.iv); //객체를 생성한 후에 인스턴스변수 참조 가능 
		
	}
	void instanceMethod() {
		System.out.println(cv);
		System.out.println(iv); //인스턴스 메서드에서는 바로 인스턴변수 사용 가능 
	}
}
