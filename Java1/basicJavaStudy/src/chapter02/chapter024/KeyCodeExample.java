package chapter02.chapter024;

public class KeyCodeExample {
	public static void main(String[] args) throws Exception{ //throws Exception : System.in.read() 에 대한 예외 처리 코드 => 단순히 모니터에 예외 내용만 출력. 이후 10장에서 자세히
		int keyCode;
		
		keyCode = System.in.read();
		System.out.println("keyCode: " + keyCode);
		
		keyCode = System.in.read();
		System.out.println("keyCode: " + keyCode);
		
		keyCode = System.in.read();
		System.out.println("keyCode: " + keyCode); 
		
//		a (97 이라는 값)+ enter(2개의 값. CR: 캐리지리턴, 13. LF: 라인피드, 10)차례대로
//		keyCode: 97	=> a 에 대한 값
//		keyCode: 13 => enter 에 대한 값
//		keyCode: 10 => enter 에 대한 값
	}
}
