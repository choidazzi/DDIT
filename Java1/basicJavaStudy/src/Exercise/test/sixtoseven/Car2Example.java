package Exercise.test.sixtoseven;

public class Car2Example {
	public static void main(String[] args) {
		Car1  m = new Car1();
		
		m.setGas(5);
		
		boolean gasState = m.isLeftGas();
		if (gasState) {
			System.out.println("go");
			m.run();
		}
		
		if (m.isLeftGas()) {
			System.out.println("필요 없습니다.");
		}else {
			System.out.println("주입하세요.");
		}
	}
}
