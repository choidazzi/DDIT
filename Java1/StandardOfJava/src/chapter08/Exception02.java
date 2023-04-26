package chapter08;

public class Exception02 {
	public static void main(String[] args) {
		int number = 100;
		int result = 0;

		for (int i = 0; i < 10; i++) {
			try {
				result = number / (int) (Math.random() * 10);
				System.out.println(result); // 0으로 나누게 될 떄 ArithmeticException 발생
			} catch (ArithmeticException e) {
				System.out.println("0");
			}
		}
	}
}
