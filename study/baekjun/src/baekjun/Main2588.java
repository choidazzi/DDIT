package baekjun;

import java.util.Scanner;

public class Main2588 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();
		int y = scan.nextInt();
		// y 자리별
		int one = y/100;
		int two = y/10%10;
		int three = y%10;
		
		System.out.println(x*three);
		System.out.println(x*two);
		System.out.println(x*one);
		System.out.println(x*y);
	}
}
