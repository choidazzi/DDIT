package Exercise.Exercise230314;

import java.util.Random;
import java.util.Scanner;

public class exercise45 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int randomNum = random.nextInt(100) + 1;
		boolean flag = true;
		int count = 0;
		while (flag) {
			System.out.print("1부터 100 사이의 정수 중 하나를 선택하세요: ");
			count ++;
			int inputNum = scanner.nextInt();
			if (inputNum == randomNum) {
				System.out.println("정답입니다.");
				System.out.println("게임을 종료합니다.");
				flag = false;
				System.out.println("시도한 횟수는 " + count + " 번 입니다.");
			} else if(inputNum < randomNum){
				System.out.println("정답은 더 큰 수 입니다.");
			} else if(inputNum > randomNum){
				System.out.println("정답은 더 작은 수 입니다.");
			}
		}
	}
}
