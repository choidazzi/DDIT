package chapter07;

public class FighterTest {
	public static void main(String[] args) {
		Fighter f = new Fighter();
		if (f instanceof Unit) { //객체 타입을 확인 
			System.out.println("f는 Unit 클래스의 자손입니다.");
		}
		
		if (f instanceof Fightable) { //객체 타입을 확인 
			System.out.println("f는 Fightable 인터페이스를 구현했습니다.");
		}
		
		if (f instanceof Movable) { //객체 타입을 확인 
			System.out.println("f는 Movable인터페이스를 구현했습니다.");
		}
		
		if (f instanceof Attackable) { //객체 타입을 확인 
			System.out.println("f는 Attackable인터페이스를 구현했습니다.");
		}
		
		if (f instanceof Object) { //객체 타입을 확인 
			System.out.println("f는 Object 클래스의 자손입니다.");
		}
		
	}
}

class Fighter extends Unit implements Fightable {

	@Override
	public void move(int x, int y) {
		//내용생략
	}

	@Override
	public void attack(Unit u) {
		//내용생략		
	}
	
}

class Unit {
	int currentHP; // 유닛의 체력 
	int x; //유닛의 위치(x좌표)
	int y; //유닛의 위치(y좌표)
}

interface Fightable extends Movable, Attackable{
	
}
interface Movable{
	void move(int x, int y);
}
interface Attackable{
	void attack(Unit u);
}
