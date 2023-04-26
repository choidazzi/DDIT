package exercise;

public class exercise44 {
	public static void main(String[] args) {
		// 1+(-2)+3+(-4)+... 과 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100이상이 되는지 구하시오.
		int sum = 0;
		int num = 0;
		int s = 1; // 부호 변경
		for (int i = 1; true; i++, s = -s) {
			num = i * s; // 1, -2, 3, -4 , ...
			sum += num; //  => sum = 1 + -2 + 3 +...
			if (sum >= 100) {
				break;
			}
		}
		System.out.println(num);
	}
}
