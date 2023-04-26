package chapter02.chapter023;

public class ByteOperationExample {
	public static void main(String[] args) {
		byte result1 = 10 + 20;
		System.out.println(result1); //피연산자가 변수가 아닌 경우. int type 으로 변경 X (숫자끼리 더하는 거니까.)
		
		byte x = 10;
		byte y = 20;
		int result2 = x + y; //연산자가 들어가면 int type으로 변경
		System.out.println(result2);
	}
}
