package chapter04;

import java.util.Scanner;

public class FlosEx10 {
	public static void main(String[] args) {
		int score = 0;
		char grade = ' ';
		
		System.out.println("당신의 점수를 입력하세요.(1~100) > ");
		Scanner scanner = new Scanner(System.in);
		int tmp = scanner.nextInt();
		
		switch (tmp/10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
			
		default:
			grade = 'D';
			break;
		}
		System.out.println("당신의 학점은" + grade + "입니다.");
	}
}
