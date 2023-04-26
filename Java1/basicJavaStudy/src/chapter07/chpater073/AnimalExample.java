package chapter07.chpater073;

public class AnimalExample {
	public static void main(String[] args) {
		Dog dog = new Dog();
		Cat cat = new Cat();

		dog.sound();
		dog.breath();
		cat.sound();
		cat.breath();

		// new Animal(); // X 현실 셰게에서는 일어날 수 없는 코드( 추상 메서드니까..)\
	   }
}