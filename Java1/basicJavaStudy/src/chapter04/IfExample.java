package chapter04;

public class IfExample {
	public static void main(String[] args) {
		int score = 93;
		//중괄호 있을 때 
		if(score >= 90) {
			System.out.println("점수가 90점보다 큽니다.");
			System.out.println("등급은 A입니다.");
		}
		//중괄호 없을 때
		if(score < 90) 
			System.out.println("점수가 90점보다 작습니다."); //if문 끝
			System.out.println("등급은 B입니다."); //if문과는 상관 없는 실행문
		
	}
}
