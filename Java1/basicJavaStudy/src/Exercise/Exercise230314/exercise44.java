package Exercise.Exercise230314;

import java.util.Scanner;

public class exercise44 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("가위 바위 보 게임");
		System.out.print("철수: ");
		String boy = scanner.next();
		System.out.print("영희: ");
		String girl = scanner.next();
		if ("가위".equals(boy) && "바위".equals(girl) 
				|| "바위".equals(boy) && "보".equals(girl)
				|| "보".equals(boy) && "가위".equals(girl)) {
			System.out.println("결과: 영희 승리!");
		} else if ("가위".equals(girl) && "바위".equals(boy) 
				|| "바위".equals(girl) && "보".equals(boy) 
				|| "보".equals(girl) && "가위".equals(boy)) {
			System.out.println("결과:철수 승리!");
		} else if (boy.equals(girl)) {
			System.out.println("결과: 비겼습니다!");
		} else {
			System.out.println("잘못 입력하셨습니다!");
		}
	}
}