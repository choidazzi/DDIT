package chapter05.chapter052;

public class AdvancedForExample {
	public static void main(String[] args) {
		int[] scores = { 95, 71, 84, 93, 87 }; //배열을 리터럴 형식으로 선언 및 초기화 
		int sum = 0;
//		1. for i
//		for (int i = 0; i < scores.length; i++) {
//			sum = sum + scores[i];
//		}
		
//		2. foreach 향상된 for문 (jdk 1.5부터 사용 가능)
		for (int score : scores) {
			sum = sum + score;
		}
		System.out.println(sum);
		
//		3. foreach라는 함수를 사용할 수도 있음 
	}
}