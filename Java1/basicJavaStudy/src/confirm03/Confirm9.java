package confirm03;

import java.util.Scanner;

public class Confirm9 {
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.print("첫번째 수: ");
		double firstNumber = Double.parseDouble(scanner.next());
		
		System.out.print("두번째 수: ");
		double secondNumber = Double.parseDouble(scanner.next());
		
		double value = firstNumber / secondNumber; 
		String result = (secondNumber == 0.0 || secondNumber == 0) ? "무한대" : String.valueOf(value);
		System.out.println("결과: " + result);
	}
}
