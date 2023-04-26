package Exercise.test.sixtoseven;

public class Plane {
	// field
	private String manufacturer;
	private String model;
	private int maxNumberOfPassengers;
	static private int numberOfPlanes;

	// Constructor
	public Plane() {
		numberOfPlanes++;
	}

	public Plane(String manufacturer, String model, int maxNumberOfPassengers) {
		this.manufacturer = manufacturer;
		this.model = model;
		this.maxNumberOfPassengers = maxNumberOfPassengers;
		numberOfPlanes++;
	}

	// method
	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
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
		this.maxNumberOfPassengers = maxNumberOfPassengers;
	}
	
	public static int getNumberOfPlanes() {
		return numberOfPlanes;
	}
}
