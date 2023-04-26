package Exercise.Exercise230326;

public class Car {
	// 필드
	private double speed; // 현재속도
	private String color; // 자동차 색상
	private static final double MAX_SPEED = 200.0; // 차의 엔진이 허용하는 최대 속력 (상수)

	// 생성자
	public Car(double speed) {
		this.speed = speed;
	}

	public Car(String color) {
		this.color = color;
	}

	// 메소드
	public double getSpeed() {
		return speed;
	}
	
	public String getColor() {
		return color;
	}

	public static double getMaxSpeed() {
		return MAX_SPEED;
	}

                      
}
