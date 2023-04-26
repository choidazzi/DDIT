package chapter07;

public class ReparableTest {
	public static void main(String[] args) {
		Tank tank = new Tank();
		Dropship dropship = new Dropship();
		Marine marine = new Marine();
		SCV scv = new SCV();
		
		scv.repair(tank); //SCV 가 Tank를 수리하도록 한다.
		scv.repair(dropship);
//		scv.repair(marine); compile error ! 
		
	}
}

interface Repairable {
	// 인터페이스를 정의하고 수리가 가능한 기계화 유닛에게 인터페이스를 구현하도록 하면 됨.
}

class Unit1 { // 게임에 나오는 모든 유닛들의 최고 조상
	int hitPoint;
	final int MAX_HP;

	Unit1(int hp) {
		MAX_HP = hp;
	}
}

class GroundUnit extends Unit1 {// 유닛의 종류1 GroundUnit
	GroundUnit(int hp) {
		super(hp);
	}
}

class AirUnit extends Unit1 { // 유닛의 종류 2 AirUnit
	AirUnit(int hp) {
		super(hp);
	}
}

class Tank extends GroundUnit implements Repairable {// Repairable 인터페이스를 구현 / 정의된 것은 없고 인스턴스의 타입 체크에만 사용!
	Tank() {
		super(150);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Tank";
	}
}

class Dropship extends AirUnit implements Repairable {
	Dropship() {
		super(125);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Dropship";
	}
}

class Marine extends GroundUnit {
	Marine() {
		super(40);
		hitPoint = MAX_HP;
	}

	public String toString() {
		return "Marine";
	}
}

class SCV extends GroundUnit implements Repairable {
	SCV() {
		super(60);
		hitPoint = MAX_HP;
	}

	void repair(Repairable r) {
		if (r instanceof Unit1) {
			Unit1 u = (Unit1) r;
			while (u.hitPoint != u.MAX_HP) {
				// Unit의 HP를 증가시킨다 .
				u.hitPoint++;
			}
			System.out.println(u.toString() + "의 수리가 끝났습니다. ");
		}
	}

}
