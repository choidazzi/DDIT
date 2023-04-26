package chapter04;

import java.util.Scanner;

public class FlowEx5 {
	public static void main(String[] args) {
		int score = 0;     
		char grade = ' ' ;
		char opt = '0';
		
		System.out.print("점수를 입력해주세요.");
		
		Scanner  sc = new Scanner(System.in);
		score = sc.nextInt(); //화면을 통해 입력받은 점수를 score에 저장
		
		System.out.printf("당신의 점수는 %d 입니다." , score);
		
		if (score >= 90) { // 90점 이상은 A
			grade = 'A'; 
			if (score >= 98) { // 90점 이상 중, 98점 이상은 A+
				opt = '+';
			} else if (score < 94) {
				opt = '-'; //90점 이상 중, 94점 미만은 A- 				
			}
		} else if (score >= 80 ) { 
			grade = 'B'; 
			if (score >= 88) { 
				opt = '+';
			} else if (score < 84) {
				opt = '-';		
			}
		} else {
			grade = 'C';
					}
		System.out.printf("당신의 학점은 %c %c 입니다. %n",grade, opt);
	}
}
