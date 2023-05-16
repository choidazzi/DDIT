package kr.or.ddit.basic.singleton;

public class SingletonTest {
	public static void main(String[] args) {
		MySingleton test1 = MySingleton.getInstance();
		MySingleton test2 = MySingleton.getInstance();
		//MySingleton test  = new MySingleton(); 	외부에서 new 명령으로 객체 생성 불가 
		
		System.out.println("test1: "+ test1.toString());
		System.out.println("test2" + test2);
		
		System.out.println("\nQ. 주소가 같나요?");
		System.out.println(test2 == test1);
		
		test1.displayTest();
	}
}
