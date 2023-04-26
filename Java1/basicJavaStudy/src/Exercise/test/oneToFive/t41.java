package Exercise.test.oneToFive;

import java.util.Scanner;

public class t41 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("first integer");
		int first = sc.nextInt();
		System.out.println("second integer");
		int second = sc.nextInt();
		System.out.println("third integer");
		int third = sc.nextInt();
		
		int max=0;
		if (first > second && first > third) {
			max = first;
		} else if (second>first && second > third) {
			max = second;
		} else if (third > first && third > second) {
			max = third;
		}
		
		if (max < first + second + third - max) {
			System.out.println("삼각형");
		} else 
			System.out.println("안됨");
	}
}
