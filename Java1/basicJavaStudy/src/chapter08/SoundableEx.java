package chapter08;

public class SoundableEx {
	public static void main(String[] args) {
		Soundable s = () -> "어흥" ; //람다식 
		System.out.println(s.sound());
		
	}
}
