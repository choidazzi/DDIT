package chapter04;

public class ifElseIfElseExample {
	public static void main(String[] args) {
		int score = 75; //변수 선언 및 초기화
	
		if (score >= 90) { //90점 이상
			System.out.println("점수가 100~90입니다.");
			System.out.println("등급은 A입니다.");
		} else if(score >= 80){ //80 <= score <90
			System.out.println("점수가 80~89입니다.");
			System.out.println("등급은 B입니다.");
		}else if(score >= 70){ //70 <= score <80
			System.out.println("점수가 70~79입니다.");
			System.out.println("등급은 C입니다.");
		}
		else { //위의 경우가 다 아닌 경우. 70점 미만
			System.out.println("점수가 70미만입니다.");
			System.out.println("등급은 D입니다.");
		}
	}
}