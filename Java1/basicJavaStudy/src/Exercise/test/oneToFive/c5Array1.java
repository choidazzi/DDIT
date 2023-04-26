package Exercise.test.oneToFive;

public class c5Array1 {
	public static void main(String[] args) {
		int[] scores = { 83, 90, 87 }; // 0, 1, 2
		
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			sum += scores[i];
		}
		System.out.println(sum);
		double avg = (double)sum/3;
		System.out.println(avg);
	}
}
