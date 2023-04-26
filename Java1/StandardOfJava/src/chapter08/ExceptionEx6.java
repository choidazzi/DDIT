package chapter08;

public class ExceptionEx6 {
	public static void main(String[] args) {
		System.out.println(1);
		System.out.println(2);
		try {
			System.out.println(3);
			System.out.println(0/0); //예외발생 
			System.out.println(4); //실행되지 않음. 
		} catch (ArithmeticException ae) {
			ae.printStackTrace();//printStackTrace() 예외발생 당시의 호출스택(Call Stack)에 있었던 메서드의 정보와 예외메시지를 화면에 출력 
			System.out.println("예외메시지: " + ae.getMessage()); 
		}System.out.println(6);
	}
}
