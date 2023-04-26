package chapter08;

public class MyClassExample {
	public static void main(String[] args) {
		MyClass class1 = new MyClass(new Audio());
		class1.rc = new Television();
		class1.rc.turnOn();
	}
}
