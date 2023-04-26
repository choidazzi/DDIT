package Exercise.exercise_self;

public class Exercise44 {
	public static void main(String[] args) {
		int s = 1; //부호 바꿔주는 역할.
		int num = 0; //번갈아 가며 나오는 숫자. 1, -2, 3, -4 ...
		int sum = 0; 
		for (int i = 1;sum <100; i++,s = -s) { // i는 1씩 더해짐. s는 1,-1,1,-1, ...
			num = i * s;
			sum += num;
		}
		System.out.println(num);
	}
}
