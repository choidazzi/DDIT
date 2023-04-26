package Exercise.test.sixtoseven;

public class Car1 {
	// 필드
	int gas;

	// 생성자

	// 메소드
	void setGas(int gas) {
		this.gas = gas;
	}

	boolean isLeftGas() {
		if (gas == 0) {
			System.out.println("없");
			return false;
		}
		System.out.println("있");
		return true;
	}

	void run() {
		while (true) {
			if (gas > 0) {
				System.out.println("잔량" + gas);
				gas -= 1;
			} else {
				System.out.println("멈춤" + gas);
				return;
			}
		}
	}
}
