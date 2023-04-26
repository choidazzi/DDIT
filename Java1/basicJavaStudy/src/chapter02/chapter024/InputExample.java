package chapter02.chapter024;

import java.util.Scanner;

public class InputExample {
	public static void main(String[] args) {
		// Scanner 라는 클래스를 이용해서 데이터 입력 String
		Scanner scanner = new Scanner(System.in); //ctrl shift o : import 해줌
		
		scanner.nextLine(); //문자열 입력. next(). enter 치기 전까지. enter 치면 String str = Scanner.nextLine(); => 형태로 변경됨
		scanner.nextInt(); //정수(int) 입력.
		scanner.nextDouble(); //실수(double) 입력
	}
}
