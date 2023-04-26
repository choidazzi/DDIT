package chapter02.chapter023;

public class PrimitiveAndStringConversionExample {
	public static void main(String[] args) {
		int value1 = Integer.parseInt("10");
		double value2 = Double.parseDouble("3.14");
		boolean value3 = Boolean.parseBoolean("true"); //세 개 다 String type 을 각각의 type으로 변환.
		//char 는 Character.parseCharacter() 존재 안 함.
		
		System.out.println("value1: " + value1);
		System.out.println("value2: " + value2);
		System.out.println("value3: " + value3);
		
		String str1 = String.valueOf(10);
		String str2 = String.valueOf(3.14);
		String str3 = String.valueOf(true); //세 개 다 각각의 type을 String type으로 변환
		
		System.out.println("str1: " + str1);
		System.out.println("str2: " + str2);
		System.out.println("str3: " + str3);
		
	char c1 = 'a';
	int c2 = c1 + 1;
	System.out.println((char)c2);
	}
}
