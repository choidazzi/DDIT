package chapter04;

import java.util.Random;

public class confirm423 {
	public static void main(String[] args) {
		Random rd = new Random();
		
		
		while (true) {
			int dice1 = rd.nextInt(6) + 1;
			int dice2 = rd.nextInt(6) + 1;
			System.out.println(dice1 +","+ dice2);
			if (dice1 + dice2 == 5) {
				break;
			}
		}
	}
}
