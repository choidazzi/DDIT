package chapter06.chapter065instance;

public class Singleton {
	private static Singleton instance  = new Singleton();
	private String name;
	private int age;
	
	public static Singleton getInstance() {
		return instance;
	}
	
	private Singleton() {
		
	}
}
