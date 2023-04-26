package Exercise.exercise_self;

public class Exercise45 {
	public static void main(String[] args) {
		int i = 0;
		while (i<=10) {
			int j = 0; // 이 자리에 넣어야 j가 다시 0으로 초기화 됨.
			while (j<=i) {
			System.out.print("*");
			j++;
			}
			i++; // 이 자리에 넣어야 첫 번째 한개의 별이 나옴.
			System.out.println();
		}
	}
}
