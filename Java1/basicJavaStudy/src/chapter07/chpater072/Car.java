package chapter07.chpater072;

public class Car {
	// 필드 (자동차는 4개의 타이어를 가짐) 
	Tire frontLeftTire = new Tire("앞왼쪽", 6); //Tire className = new Tire ("타이어의 위치" , 최대 회전 수 (=수명))
	Tire frontRightTire = new Tire("앞오른쪽", 2);
	Tire backLeftTire = new Tire("뒤왼쪽", 3);
	Tire backRightTire = new Tire("뒤오른쪽", 4);

	// 생성자
	// 메소드 - 모든 타이어를 1회 회전시키기 위해 tire class의 roll()메서드 호출 
	int run() {
		System.out.println("[자동차가 달립니다.]");
		if (frontLeftTire.roll() == false) { //false = 펑크가 났을 
			stop(); return 1; 
		}
		if (frontRightTire.roll() == false) {
			stop(); return 2; 
		}
		if (backLeftTire.roll() == false) {
			stop(); return 3; 
		}
		if (backRightTire.roll() == false) {
			stop(); return 4; 
		}
		return 0;
	}

	void stop() {
		System.out.println("[자동차가 멈춥니다.]");
	}
}
