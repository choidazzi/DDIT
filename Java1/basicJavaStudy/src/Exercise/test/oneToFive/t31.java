package Exercise.test.oneToFive;

import java.util.Scanner;

public class t31 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("일");
		int n1 = sc.nextInt();
		System.out.println("이");
		int n2 = sc.nextInt();
		
		int big = ((n1 + n2) + Math.abs(n1 - n2))/2;
		int small = ((n1 + n2) - Math.abs(n1 - n2))/2;
		System.out.println(big/small);
		System.out.println(big%small);
	}
}
