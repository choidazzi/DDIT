package chapter10;

import java.util.Scanner;

public class finallyExample {
	public static void main(String[] args) {
		Scanner scanner = null;
		try {
			scanner = new Scanner(System.in);
			int num1 = scanner.nextInt();
			int num2 = scanner.nextInt();
			int result = num1 + num2;
			System.out.println("결과: " + result);
		} catch (Exception e) {
			e.printStackTrace();
			return;
		} finally { // 무조건 실행 
			if (scanner != null) {
				scanner.close(); //메모리 낭비 정리해줌.( try 내에 scanner 있으면 error  왜냐하면 블럭 내에 scanner 없으니까.) 							
			}
		}
	}
}
