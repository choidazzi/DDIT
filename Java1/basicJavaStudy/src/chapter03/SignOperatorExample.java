package chapter03;

public class SignOperatorExample {
	public static void main(String[] args) {
		int x = -100;
		int result1 = +x;
		int result2 = -x;
		System.out.println("result1: " + result1);
		System.out.println("result2: " + result2);
		
		byte b = 100;
		//byte result3 = -b; //컴파일 에러.부호연산자 - 가 있으므로 int type.
		int result3 = -b;
		System.out.println("result3: " + result3);
	}
}
