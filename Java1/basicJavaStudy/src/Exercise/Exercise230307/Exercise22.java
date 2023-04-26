package Exercise.Exercise230307;


public class Exercise22 {
	public static void main(String[] args) {
		double distance = 40e12;
		double speed = 3e5; 
		double time = (distance / speed / 3600 /24 / 365); //speed에 곱셈말고 time에 나눗셈(수가 커지면 안 좋음)
		
		
		System.out.printf("빛의 속도로 프록시마 센타우리 별까지 가는데 걸리는 시간은 %17.15f광년이다.", time);
	}
}
