package chapter05.chapter051;

import java.util.Scanner;

public class StringEqualsExample {
	public static void main(String[] args) {
//		//String 참조타입
//		//jdk 1.5 or 1.7 부터 String Pool이라는 공간을 만들었음 (Pool) 
//		int a = 10;
//		String str1 = new String("홍길동"); //heap > String 에 주소를 만들고 "홍길동" stack에 저장..?  //0x1234 //잘 이해 안감.. 
//		//메모리적 낭비.. 아래의 방법선호,,,!
//		String str2 = "홍길동"; //"홍길동" > 리터럴. 리터럴로 문자열을 저장할 때 String Pool 에 저장 //0x1235
//		String str3 = "홍길동" ; //0x1235
//		//비교할 때 equals( ) 사용. 논리연산자 사용 X

		String strVar1 = "신민철";
		String strVar2 = "신민철";

		if (strVar1 == strVar2) {
			System.out.println("strVar1과 strVar2는 참조가 같음.");
		} else {
			System.out.println("strVar1과 strVar2는 참조가 다름.");
		}
		
		if (strVar1.equals(strVar2)) {
			System.out.println("strVar1과 strVar2는 문자열이 같음.");
		}
		String strVar3 = new String("신민철");
		String strVar4 = new String("신민철");

		if (strVar3 == strVar4) {
			System.out.println("strVar3과 strVar4는 참조가 같음.");
		} else {
			System.out.println("strVar3과 strVar4는 참조가 다름.");
		}
		if (strVar3.equals(strVar4)) {
			System.out.println("strVar1과 strVar2는 문자열이 같음.");
		}
		String str = null;
		str= "홍길동";
		System.out.println(str); //NullPointerException 안뜸. String은 참조타입이지만 기본타입으로 생각...하자... 
		
		Scanner scanner = null;
		int nextInt = scanner.nextInt(); //NullPointerException 뜸. 
	}
}