package chapter04;

import java.util.Random;
import java.util.Scanner;

public class FlowEx7 {
	public static void main(String[] args) {
		System.out.print("가위(1), 바위(2), 보(3) 중 하나를 입력하세요. > ");
		Scanner scanner = new Scanner(System.in);
		int user = scanner.nextInt(); //화면을 통해 입력받은 숫자를 user에 저장 
		Random random = new Random();
		int com = random.nextInt(3) + 1;
		
		System.out.println("당신은 " + user + "입니다.");
		System.out.println("컴퓨터는" + com + "입니다.");
		
		switch (user - com) {
		case 1:
		case -2:
			System.out.println("유저가 승리");
			break;

		case -1:
		case 2:
			System.out.println("컴퓨터가 승리");
			break;
			
		case 0:
			System.out.println("무승부");
			break;
		}
		
	}
}
