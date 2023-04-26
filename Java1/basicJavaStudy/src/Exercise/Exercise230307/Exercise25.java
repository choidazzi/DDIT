package Exercise.Exercise230307;

import java.util.Scanner;

public class Exercise25 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("500원짜리 동전의 갯수: ");
		String fiveHundredCoin = scanner.nextLine();
		
		System.out.print("100원짜리 동전의 갯수: ");
		String oneHundredCoin = scanner.nextLine();
		
		System.out.print("50원짜리 동전의 갯수: ");
		String fifthCoin = scanner.nextLine();
		
		System.out.print("10원짜리 동전의 갯수: ");
		String tenCoin = scanner.nextLine();
		
		int fiveHundred = Integer.parseInt(fiveHundredCoin) * 500;
		int oneHundred = Integer.parseInt(oneHundredCoin) * 100;
		int fifth = Integer.parseInt(fifthCoin) * 50;
		int ten = Integer.parseInt(tenCoin) * 10;
		int total = fiveHundred + oneHundred + fifth + ten;
		
		System.out.printf("저금통 안의 동전의 총 액수: %d", total);
	}
}
