package Exercise.test.oneToFive;

import java.util.Scanner;

public class t32 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("수도");
		int city = sc.nextInt();
		System.out.println("인구");
		int peo = sc.nextInt();
		System.out.println("1억");
		int income = sc.nextInt();
		
		String metro = (city ==1 && peo >= 100 || income >= 50)? "메트로 폴리스" : "아님" ; 
		System.out.println(metro);
	}
}
