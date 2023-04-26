package chapter05.chapter052;

public class ArrayCreateByValueListExample {
	public static void main(String[] args) {
		int[] scores = {83, 90, 87};
		//						0    1    2
		System.out.println("scores[0]: " + scores[0]);
		System.out.println("scores[1]: " + scores[1]);
		System.out.println("scores[2]: " + scores[2]);
		
		int sum = 0;
		for (int i = 0; i < scores.length ; i++) {
			sum += scores[i];
		}
		System.out.println("\n총합: " + sum);
		double avg = (double) sum / 3;
		System.out.println("평균: " + avg);
	}
}
