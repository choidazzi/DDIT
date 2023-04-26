package Exercise.test;

public class Car {
	//f
	private double speed;
	private String color;
	private static double MAX_SPEED = 200.0;
	
	//c
	public Car() {
		// TODO Auto-generated constructor stub
	}
	public Car(String color) {
		this.color = color;
	}
	
	//m
	public double getSpeed() {
		return speed;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public static double getMaxSpeed() {
		return MAX_SPEED;
	}
	
	public boolean speedUp(double speed) {
		if (this.speed + speed <= MAX_SPEED && this.speed + speed > 0) {
			this.speed += speed;
			return true;
		} return false;
	}
}




















