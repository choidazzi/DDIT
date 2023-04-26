package Exercise.Exercise230319;

public class Exercise51 {
	public static void main(String[] args) {
		int[] array = {38, 94, 16, 3, 76, 94, 82, 47, 59, 8};
		int max = 0;
		int min = array[0];
		
		for (int i : array) {
			if (max < i) {
				max = i;
			}
		}
		for (int i : array) {
			if (min > i) {
				min = i;
			}
		}
		
		System.out.println("최댓값: " + max);
		System.out.println("최소값: " + min);
	}
}
