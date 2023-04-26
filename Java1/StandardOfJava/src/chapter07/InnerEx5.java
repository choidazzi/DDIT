package chapter07;

class Outer1{
	int value = 10; //Outer.this.value
	
	class Inner{
		int value = 20; // this.value
		
		void method1() {
			int value = 30;
			System.out.println("               value : " + value); //30
			System.out.println("         this.value : " + this.value); //20 
			System.out.println("Outer.this.value : " + Outer1.this.value); //10 
		}
	}
}

public class InnerEx5 {
	public static void main(String[] args) {
		Outer1 outer = new Outer1();
		Outer1.Inner inner = outer.new Inner();
		inner.method1();
	}
}
