package confirm06;

public class Car {
	
	String company = "현대자동차";
	String model;
	String color;
	int maxSpeed;
	
	// java bean pattern, builder pattern 
	// telescoping constructor pattern 텔레스코핑 생성자 패턴 (아래처럼 망원경처럼 퍼지는 패턴) 
	public Car() {

	}
	public Car(String model) {
		this.model = model;
	}
	public Car(String model, String color) {
		this.model = model;
		this.color = color;
	}
	public Car(String model, String color, int maxSpeed) {
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}	
}
