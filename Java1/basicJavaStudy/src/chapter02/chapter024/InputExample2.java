package chapter02.chapter024;

import java.util.Scanner;

public class InputExample2 {
	public static void main(String[] args) {
		// Scanner 라는 클래스를 이용해서 데이터 입력 String
		Scanner scanner = new Scanner(System.in); //ctrl shift o : import 해줌
		
		String str = scanner.nextLine();
		//int intValue = scanner.nextInt();
		int intValue = Integer.parseInt(scanner.nextLine()); //더 좋은 방법
		double doubleValue = scanner.nextDouble();
		System.out.println(str + "=" + (intValue + doubleValue));
	}
}