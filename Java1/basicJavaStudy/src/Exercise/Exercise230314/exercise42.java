package Exercise.Exercise230314;

import java.util.Scanner;

public class exercise42 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("월을 입력하세요(1~12)");
		int month = scanner.nextInt();
		
		if (month >= 3 && month <=5) {
			System.out.println(month + "월은 봄입니다.");
		} else if(month >= 6 && month <=8) {
			System.out.println(month + "월은 여름입니다.");
		} else if(month >= 9 && month <=11) {
			System.out.println(month + "월은 가을입니다.");
		} else if(month == 12 || month<= 2) {
			System.out.println(month + "월은 겨울입니다.");
		} else {
			System.out.println(month + "월은 잘못된 입력입니다.");
		};
	}
}
