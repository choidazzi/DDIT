package chapter11.String;

public class StringEqualsExample {
	public static void main(String[] args) {
		String strvar1 = new String("신민철");
		String strvar2 = "신민철";
		
		if (strvar1 == strvar2) {
			System.out.println("같은 String 객체를 참조");
		} else {
			System.out.println("다른 String 객체를 참조");			
		}
		if (strvar1.equals(strvar2)) {
			System.out.println("같은 문자열을 가짐");
		} else {
			System.out.println("다른 문자열을 가짐");			
		}
	}
}
