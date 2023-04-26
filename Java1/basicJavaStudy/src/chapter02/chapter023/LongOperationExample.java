package chapter02.chapter023;

public class LongOperationExample {
	public static void main(String[] args) {
		long value1 = 10;
		int value2 = 100;
		long value3 = 1000L;
		long result = value1 + value2 + value3; //가장 큰 타입인 long type 으로 변경됨.
		System.out.println(result); 
	}
}
