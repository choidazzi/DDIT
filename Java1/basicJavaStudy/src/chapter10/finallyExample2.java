package chapter10;

import java.util.Scanner;

public class finallyExample2 {
	public static void main(String[] args) {
		try(Scanner scanner = new Scanner(System.in)) { //jdk 1.7 부터 사용 가능. try catch with resource 
			int num1 = scanner.nextInt();
			int num2 = scanner.nextInt();
			int result = num1 + num2;
			System.out.println("결과: " + result);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}
	}
}
