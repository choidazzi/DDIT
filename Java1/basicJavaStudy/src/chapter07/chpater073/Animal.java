package chapter07.chpater073;

public abstract class Animal {
	public String kind;
	public void breath() {
		System.out.println("숨을 쉽니다.");
	}
	public abstract void sound(); //동물이라면 소리를 내야함. => 소리를 내는 규격을 정해놓는 역할 
	
}
