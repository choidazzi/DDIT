package chapter06.package02;

public class Car {
	private int speed = 0; //필드는 private 선언 왜냐하면 직접 speed에 접근하면 안됨 . 
	private boolean stop;
	public int getSpeed() { //따라서 getSpeed 로 접근  //얻고 
		return speed;
	}
	
	public void setSpeed(int speed) {  //세팅 
		if (speed > 0) {
			this.speed = speed; 	
			return;
		} //else {
//			this.speed =0; 생략 가능. 왜냐하면 위에 필드 0으로 초기화 했으니까. 
//		}
	}
	
	public boolean isStop() {
		return stop;
	}
	
}
