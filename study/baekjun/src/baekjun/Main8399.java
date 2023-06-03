package baekjun;

import java.util.Scanner;

public class Main8399 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int x = scan.nextInt();
		int sum = 0;
		for(int i=0; i<=x; i++) sum += i;
		
		System.out.println(sum);
	}
}
