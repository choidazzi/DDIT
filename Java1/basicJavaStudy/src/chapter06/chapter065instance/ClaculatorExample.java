package chapter06.chapter065instance;


public class ClaculatorExample {
	public static void main(String[] args) {
		Calculator cal = new Calculator();
		System.out.println(	cal.plus(2,3));
		
		//반지름이 5인 원의 넓이를 구한다.
		double result = 5 * 5* Calculator.pi;
		System.out.println(result);
		
		//뺄셈연산을 한다. 100 -24
		System.out.println(Calculator.minus(100,24));
		System.out.println(Calculator.minus(30,24));
	}
}
