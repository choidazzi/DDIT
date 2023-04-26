package chapter04;

import java.util.Scanner;

public class FlowEx34 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		outer: while (true) {
			System.out.println("(1) sauare");
			System.out.println("(2) sauare root");
			System.out.println("(3) log");
			System.out.print("원하는 메뉴(1~3)를 선택하세요. (종료: 0) > "); // 원하는 공식 선택. 제곱? 제곱근? 로그? 
			
			int menu = scanner.nextInt(); // 메뉴 입력 
			
			if (menu == 0) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else if (!(1 <=menu && menu <= 3)) {
				System.out.println("메뉴를 잘못 선택하셨습니다. (종료:0)");
				continue;
			}
			
			for (;;) {
				System.out.println("계산할 값을 입력하세요. (계산 종료: 0, 전체 종료: 99) > ");
				int num = scanner.nextInt(); // 값입력 
				
				if (num == 0) {
					break; //계산종료. for문을 벗어난다. 
				}
				if (num == 99) {
					System.out.println("전체 종료");
					break outer; //전체종료. for문과 while 문을 벗어난다.
				}
				switch (menu) {
				case 1:
					System.out.println("result: " + num * num); // 제곱 
					break;
				case 2:
					System.out.println("result: " + Math.sqrt(num)); // 제곱근
					break;
				case 3:
					System.out.println("result: " + Math.log(num)); // 로그 
					break;
				} //for
			}//while
		}//main
	}
}
