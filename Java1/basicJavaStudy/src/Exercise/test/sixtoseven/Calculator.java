package Exercise.test.sixtoseven;

public class Calculator {
	int plus(int x, int y) {
		int result = x + y;
		return result;
	}
	
	double avg(int x, int y) {
		double sum = plus(x,y);
		return sum/2;
	}
	
	void execute() {
		double result = avg(7,10);
		System.out.println(result);
	}
	
	void println(String message) {
		System.out.println(message);
	}
}
