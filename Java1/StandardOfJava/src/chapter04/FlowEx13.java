package chapter04;

import java.util.Iterator;

public class FlowEx13 {
	public static void main(String[] args) {
		int sum = 0;
		
		for (int i = 1; i <= 10; i++) {
			sum += 1;
			System.out.printf("1부터 %2d 까지의 합: %2d%n" , i, sum); //%2d 두자리값을 가진다. 
		}
	}
}
