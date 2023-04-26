package chapter02.chapter024;

public class ContinueKeyCodeReadExample {
	public static void main(String[] args) throws Exception {
		int keyCode;
		
		while(true) {
			keyCode = System.in.read();
			System.out.println("KeyCode: " + keyCode); //while 반복문을 사용하면 모든 keycode 를 읽음.
		}
	}
}
