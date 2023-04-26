package confirm05;

import java.util.Iterator;
import java.util.Scanner;

public class exercise6 {
	public static void main(String[] args) {
		boolean run = true;
		int studentNum = 0;
		int[] scores = null;
		Scanner scanner = new Scanner(System.in);

		while (run) {
			System.out.println("----------------------------------------------------------------------");
			System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5 종료");
			System.out.println("----------------------------------------------------------------------");
			System.out.print("선택> ");

			int selectNo = Integer.parseInt(scanner.nextLine());

			if (selectNo == 1) {
				System.out.print("학생수: ");
				studentNum = Integer.parseInt(scanner.nextLine());
				scores = new int[studentNum];
			} else if (selectNo == 2) {
				for (int i = 0; i < studentNum; i++) {
					System.out.print("score[" + i + "] > ");
					scores[i] = Integer.parseInt(scanner.nextLine());
				}
			} else if (selectNo == 3) {
				for (int i = 0; i < scores.length; i++) {
					System.out.println("score[" + i + "] > " + scores[i]);
				}
			} else if (selectNo == 4) {
				double sum = 0;
				int count = 0;
				double avg = 0;
				int max = 0;
				for (double score : scores) {
					count++;
					sum += score;
					avg = sum / count;
				} 
				for (int i :scores) {
					if (i>max) {
						max = i;
					}
				}
				System.out.println("최고점: " + max);
				System.out.println("평균: " + avg);
			} else if (selectNo == 5) {
				run = false;
			}
		}
		System.out.println("프로그램 종료");
	}
}
