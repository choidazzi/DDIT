package chapter07.chpater072;

public class DriverExample {
	public static void main(String[] args) {
		Driver driver = new Driver(); //아래 driver.drive() 사용 위해 
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus);
		driver.drive(taxi);
	}
}
