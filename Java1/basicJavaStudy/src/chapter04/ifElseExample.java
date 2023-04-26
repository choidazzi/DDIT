package chapter04;

public class ifElseExample {
	public static void main(String[] args) {
		int score = 85;
		
		if (score >= 90) { //조건문 true
			System.out.println("점수가 90점보다 큽니다.");
			System.out.println("등급은 A입니다.");
		} else { //조건문 false
			System.out.println("점수가 90점보다 작습니다.");
			System.out.println("등급은 B입니다.");
		}
	}
}
