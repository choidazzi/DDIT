package Exercise.test.oneToFive;

import java.util.Random;
import java.util.Scanner;

public class t45 {
	public static void main(String[] args) {
		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		int num = rd.nextInt(100) + 1;
		System.out.println(num);
		
		while (true) {			
			System.out.println("1~100 선택");
			int ber = sc.nextInt(); 
			if (num == ber) {
				System.out.println("게임을 종료합니다.");
				break;
			} else if (num > ber) {
				System.out.println("더 작은 수");
			} else
				System.out.println("큰 수");
		}
	}
}
