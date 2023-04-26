package Exercise.Exercise230319;

import java.util.Random;

public class Exercise54 {
	public static void main(String[] args) {
		Random rd = new Random();
		int[] dice = new int[6]; 	//6자리의 배열 선언 
		System.out.println("----------------------");
		System.out.println("  면\t\t 빈도");
		System.out.println("----------------------");
		for (int i = 1; i <= 10000; i++) {
			dice[rd.nextInt(6)]++; //ex. dice[i] =i (rd.nextInt() 값이 i일 때 1씩 더함.) 
		}
		for (int i = 0; i < 6; i++) {
			System.out.println("  " + (i+1) +"\t\t"+ dice[i]);
		}
	}
}
