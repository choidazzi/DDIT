package chapter04;

import java.util.Scanner;

public class FlowEx27 {
	public static void main(String[] args) {
		int sum = 0;
		boolean flag = true; //while의 조건식으로 사용될 변수 
		
		System.out.println("합계를 구할 숫자를 입력하세요. (끝내려면 0을 입력)");
		Scanner scanner = new Scanner(System.in);
		while (flag) {
			System.out.print(">>");
			int num = scanner.nextInt();
			
			if (num != 0) {
				sum += num; //num이 0이 아니면 sum에 더한다.
			} else {
				flag = false; //num이 0이면 flag 의 값을 false 로 변경. 
			}
		}//while 끝
		System.out.println("합계: " + sum);
	}
}
