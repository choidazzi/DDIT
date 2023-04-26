package Exercise.Exercise230326;

public class Plane {
//필드
	private String manufacturer; // 제작사
	private String model; // 비행기 모델명
	private int maxNumberOfPassengers; // 최대 승객수
	private static int numberOfPlanes; // 생성된 비행기 객체의 수

	// 생성자
	public Plane() {
		numberOfPlanes++;
	}	
	
	public Plane(String manufacturer, String model, int maxNumberOfpassengers) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.maxNumberOfPassengers = maxNumberOfpassengers;
		numberOfPlanes++;
	}

	// 메소드

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer =  manufacturer;
	}
	
	public String getModel() {
		return model;
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public int getMaxNumberOfPassengers() {
		return maxNumberOfPassengers;
	}
	
	public void setMaxNumberOfPassengers(int maxNumberOfPassengers) {
		if (maxNumberOfPassengers > 0) {
			this.maxNumberOfPassengers = maxNumberOfPassengers;
		} 
	}
	
	public static int getNumberOfPlanes() {
		return numberOfPlanes;
	}
}
