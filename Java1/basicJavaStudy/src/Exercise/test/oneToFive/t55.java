package Exercise.test.oneToFive;

public class t55 {
	public static void main(String[] args) {
		int[][] array = {
				{95,86},
				{83,92,96},
				{78,83,93,87,88}
		};
		
		int sum = 0;
		double avg = 0.0;
		
		double count = 0;
		for (int[] arr1 : array) {
			for (int arr2 : arr1) {
				count++;
				sum += arr2;
				avg = sum / count;
			}
		}
		
		System.out.println(sum);
		System.out.println(avg);
	}
}
