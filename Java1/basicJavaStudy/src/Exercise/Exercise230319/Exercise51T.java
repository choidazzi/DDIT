package Exercise.Exercise230319;

public class Exercise51T {
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE; // 가장 작은 값으로 시작.
		int min = Integer.MAX_VALUE; // 가장 큰 값으로 시작.
		int[] array = { 38, 94, 16, 3, 76, 94, 82, 47, 59, 8 };
		
		for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
			if (array[i] < min) {
				min = array[i];
			}
		}
		System.out.println(max);
		System.out.println(min);
	}
}
