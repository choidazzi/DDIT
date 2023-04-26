package chapter02.chapter024;

public class PrintExample {
	public static void main(String[] args) {
		int value = 123;
		System.out.printf("상품의 가격: %d원\n", value); //정수 =>123
		System.out.printf("상품의 가격: %6d원\n", value); //6자리 가지는 정수, 왼쪽 빈자리 공백 =>___123
		System.out.printf("상품의 가격: %-6d원\n", value); //6자리 가지는 정수, 오른쪽 빈자리 공백 =>123___   
		System.out.printf("상품의 가격: %06d원\n", value); //6자리 가지는 정수, 왼쪽 빈자리 0채움 =>000123
		
		double area = 3.14159 * 10 * 10;
		System.out.printf("반지름이 %d인 원의 넓이: %10.2f\n ", 10 , area); //=>____314.16

		
		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d : %-10s : %10s\n" , 1 , name , job); //=>문자열은 %s
		
	}
}
