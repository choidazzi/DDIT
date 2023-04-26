package chapter11.String;

import java.io.IOException; //다른 패키지 

public class KeyboardToStringExample {
	public static void main(String[] args) throws IOException {
		byte[] bytes = new byte[100]; //읽은 바이트를 저장하기 위한 배열 생성 
		
		System.out.print("입력:");
		int readByteNo = System.in.read(bytes); //배열에 읽은 바이트를 저장하고 읽은 바이트 수를 리턴 
		String str = new String(bytes, 0 ,readByteNo-1); //배열은 문자열으로 반환 (윈도우는 	\n\r 맥은 \n)
		System.out.println(str);
	}
}
