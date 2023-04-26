package chapter02.chapter021;

public class VariableExchangeExample {
	public static void main(String[] args) {
		int x = 3;
		int y = 5;
		System.out.println("x:" + x + " y:" + y);
		
		int temp = x; //temp에 3값을 저장 
		x = y; //x에 5를 저장
		y = temp; //temp 값 3을 y에 저장 , 따라서 x:5 , y:3
		System.out.println("x:" + x + " y:" + y);
	}
}
//변수 이름은 첫문자를 대문자(관례) , _ 쓰지 말기
//ex.maxSpeed, firstName, carBodyColor : camel case(---^--- 낙타 등같이 생겨서) - naming convention