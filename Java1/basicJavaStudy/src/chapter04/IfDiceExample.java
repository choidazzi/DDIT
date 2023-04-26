package chapter04;

import java.util.Random;

public class IfDiceExample {
	public static void main(String[] args) {
		Random random = new Random();
//		random.nextInt(int bound) , bound는 범위?
//		Math.random() * int : 위의 방법 사용하기
//		SecureRandom    <  제일 랜덤, 선호.
	
		int num = random.nextInt(5) + 1; //0부터 5까지 > +1 > 1부터 6까지
		System.out.println();
		
		switch (num) {
		case 1:
			System.out.println("1번이 나왔습니다.");
			break;
		case 2:
			System.out.println("2번이 나왔습니다.");
			break;
		case 3:
			System.out.println("3번이 나왔습니다.");
			break;
		case 4:
			System.out.println("4번이 나왔습니다.");
			break;
		case 5:
			System.out.println("5번이 나왔습니다.");
			break;

		default:
			System.out.println("6번이 나왔습니다.");
			break;
		}
	}
}
