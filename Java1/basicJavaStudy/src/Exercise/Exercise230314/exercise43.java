package Exercise.Exercise230314;

import java.util.Scanner;

public class exercise43 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("점수를 입력하세요.");
		System.out.print("프로그래밍 기초: ");
		int programming = scanner.nextInt();
		System.out.print("데이터베이스: ");
		int dataBase = scanner.nextInt();
		System.out.print("화면 구현: ");
		int screen = scanner.nextInt();
		System.out.print("애플리케이션 구현: ");
		int app = scanner.nextInt();
		System.out.print("머신러닝: ");
		int muchineRunning = scanner.nextInt();
		//총점 & 평균 
		int totalScore = programming + dataBase + screen + app + muchineRunning;
		int average = totalScore / 5; 
		System.out.println("총점: " + totalScore);
		System.out.println("평균: " + average);
		//학점 
		if (average >= 90) {
			System.out.println("학점: A");
		} else if(average >= 80){
			System.out.println("학점: B");
		} else if(average >= 70){
			System.out.println("학점: C");
		} else if(average >= 60){
			System.out.println("학점: D");
		} else if(average < 60){
			System.out.println("학점: F");
		}
	}
}
