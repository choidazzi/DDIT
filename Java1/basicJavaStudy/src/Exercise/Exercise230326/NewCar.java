package Exercise.Exercise230326;

public class NewCar {
	// 필드
	private double speed; // 현재속도
	private String color; // 자동차 색상
	private static double MAX_SPEED = KilloToMile(200.0); // 차의 엔진이 허용하는 최대 속력 (상수)

	// 생성자
	public NewCar(double speed) {
		this.speed = speed;
	}

	public NewCar(String color) {
		this.color = color;
	}

	// 메소드
	public double getSpeed() {
		return MileToKillo(speed);
	}

	public void setSpeed(double speed) {
		this.speed =  KilloToMile(speed);
	}

	public String getColor() {
		return color;
	}

	public static double getMaxSpeed() {
		return MileToKillo(MAX_SPEED);
	}

	public boolean speedUp(double speed) { //속도를 올리거나 내리는 메서드 
		this.speed = KilloToMile(speed);
		if (this.speed+ speed > 0 && this.speed + speed <= MAX_SPEED) { 
			this.speed += speed;
			return true;			
		} return false;
	}

	private static double KilloToMile(double distance) {
		return distance / 1.6;
	}

	private static double MileToKillo(double distance) {
		return distance * 1.6;
	}
}
