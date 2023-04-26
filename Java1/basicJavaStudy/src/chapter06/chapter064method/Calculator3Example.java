package chapter06.chapter064method;

public class Calculator3Example {
	public static void main(String[] args) {
		Calculator3 myCalccu = new Calculator3();
		//정사각형의 넓이
		double result1 = myCalccu.areaRectangle(10);
		
		//직사각형의 넓이 
		double result2 = myCalccu.areaRectangle(10, 20);
		
		System.out.println("정사각형 넓이= " + result1);
		System.out.println("직사각형 넓이= " + result2);
	}
}
