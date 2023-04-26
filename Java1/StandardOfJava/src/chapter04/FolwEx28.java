package chapter04;

import java.util.Random;
import java.util.Scanner;

public class FolwEx28 {
	public static void main(String[] args) {
		int input = 0, answer = 0;
		
		Random random = new Random();
		Scanner scanner = new Scanner(System.in);
		answer = random.nextInt(100) + 1;
//		System.out.println(answer);
		do {
			System.out.print("1과 100사이의 정수를 입력하세요. > ");
			input = scanner.nextInt();
			if (input > answer) {
				System.out.println("더 작은 수로 다시 시도해주세요.");
			} else if(input < answer){
				System.out.println("더 큰 수로 다시 시도해주세요.");
			}
		} while (input != answer);
		System.out.println("정답입니다.");
	}
}
