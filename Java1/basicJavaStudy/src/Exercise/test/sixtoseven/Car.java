package Exercise.test.sixtoseven;

public class Car {
	//필드
	String model;
	String color;
	int maxSpeed;
	
	//생성자 - 메소드 오버로
	public Car() { }
	public Car(String model) { 	
		this(model, "은색", 250);
	}
	public Car(String model, String color) { 
		this(model, color, 250);
	}
	public Car(String model, String color, int maxSpeed) { 
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
}
