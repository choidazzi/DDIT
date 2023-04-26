package Exercise.Exercise230319;

import java.util.Random;
import java.util.Scanner;

public class Exercise53 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		boolean run = true;
		
		while (run) {
			String[] rps = { "가위", "바위", "보" };
			System.out.print("가위 바위 보를 입력하세요: ");
			// 게이머
			String gamer = sc.next();
			System.out.println("게이머: " + gamer);
			// 인공지능
			String rpsAi = rps[rd.nextInt(3)];
			System.out.println("인공지능 컴퓨터: " + rpsAi);

			if (gamer.equals("바위") && rpsAi.equals("가위") 
					|| gamer.equals("가위") && rpsAi.equals("보")
					|| gamer.equals("보") && rpsAi.equals("바위")) {
				System.out.println("게이머 승리! 게임을 종료합니다.");
				//이기면 게임 종료 
				run = false; 
			} else if (gamer.equals("바위") && rpsAi.equals("보") 
					|| gamer.equals("가위") && rpsAi.equals("바위")
					|| gamer.equals("보") && rpsAi.equals("가위")) {
				System.out.println("인공지능 승리! 다시 도전해보세요.");
				System.out.println("\n---------------재도전---------------\n");
			} else if (gamer.equals(rpsAi)) {
				System.out.println("비겼습니다! 다시 도전해보세요.");
				System.out.println("\n---------------재도전---------------\n");
			} else {
				System.out.println("잘못된 값을 입력하셨습니다.");
				System.out.println("\n---------------재도전---------------\n");
			}
		}

	}
}
