package chapter01;
public class Hello {
	/**
	 * 이 메소드는 Hello 클래스의 main 메소드
	 * @param args 프로그램 실행시 넣어줄 데이터 
	 */
	public static void main(String[] args) {
		System.out.println("Hello, Java");
		System.out.println("덧셈 결과: " + (Integer.parseInt(args[0]) + Integer.parseInt(args[1])));
	}
} 
/*ctrl + f11: run*/

//이 내용은 컴파일 되지 않는다. 한 줄 주석

/* 여러 줄 주석
 * 
 * 
 */


