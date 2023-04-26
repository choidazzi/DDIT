package chapter08;

public class soundableExample {
	private static void printSound(Soundable soundable) {
		System.out.println(soundable.sound());
	}
	
	public static void main(String[] args) {
		printSound(new Cat()); //printSound ps = new printSound(new Cat());
		printSound(new Dog());//printSound ps = new printSound(new Dog());
	}
}


