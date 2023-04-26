package Exercise.test.oneToFive;

import java.util.Scanner;

public class t21 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("가로의 길이는?");
		double width = sc.nextDouble();
		System.out.println("세로의 길이는?");
		double height = sc.nextDouble();
		System.out.println("넓이: " + width * height);
		System.out.println("둘레: " + 2*(width + height));
	}
}
