package chapter06;

class Tv{
	//Tv의 속성(멤버변수) 
	String color;
	boolean power;
	int channel;
	
	void power() {
		power = !power;
		}
	void channelUp() {
		++channel;
	}
	void channelDown() {
		--channel;
	}
}

public class TvTest {
	public static void main(String[] args) {
		Tv t; //Tv 인스턴스를 참조하기 위한 변수 t를 선언 
		t = new Tv(); //인스턴스 생성 . 22 & 23 Tv t = new Tv(); 을 두 줄로 표현 
		t.channel = 7; //인스턴스의 멤버변수 channel 의 값을 7로 한다.  
		t.channelDown(); //메서드 channelDown() 호출 
		System.out.println("현재 채널은" + t.channel + "입니다.");
	}
}
