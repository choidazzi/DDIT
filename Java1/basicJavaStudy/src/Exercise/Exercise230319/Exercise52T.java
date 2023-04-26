package Exercise.Exercise230319;

import java.util.Random;

public class Exercise52T {
	public static void main(String[] args) {
		int[] array = new int[45];
		Random random = new Random();
		for (int i = 0; i < 45; i++) {
			array[i] = i + 1;
		}
		for (int i = 0; i < array.length; i++) {
			int num2 = random.nextInt(45);
			int temp = array[i];
			array[i] = array[num2];
			array[num2] = temp;
		}
		for (int i = 0; i < 6; i++) {
//			if (i != 0) {
//				System.out.print(",");
//			}
//			System.out.print(array[i]);
			System.out.print((i != 0 ? "," : "") + array[i]); 
		}
	}
}
