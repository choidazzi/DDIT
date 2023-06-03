package baekjun;

import java.util.Scanner;

public class Main25304 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int total = scan.nextInt();
		int su = scan.nextInt();
		
		int prodPrice = 0;
		for(int i=0; i<su; i++) {
			int price = scan.nextInt();
			int prodSu = scan.nextInt();
			
			prodPrice += price * prodSu;
		}
		
		if(prodPrice == total) System.out.println("Yes");
		else System.out.println("No");
	}
}
