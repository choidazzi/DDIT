package Exercise.exercise_self;

public class Exercise43 {
	public static void main(String[] args) {
//		int sum = 0;
//		for (int i = 1; i <= 10; i++) {
//			sum += i;
//			for (int j = 1; j < i; j++) {
//			sum += j;
//			}
//		}
//		System.out.println(sum);
		//해답
		int sum =0;
		int totalSum = 0;
		for (int i = 1; i <= 10; i++) {
			sum+=i;
			totalSum += sum;
		}
		System.out.println(totalSum);
	}
}
