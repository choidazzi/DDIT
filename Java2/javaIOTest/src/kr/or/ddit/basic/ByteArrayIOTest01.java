package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest01 {
	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;
		
		// byte 배열을 이용해서 입력하는 스트림 객체 생성 
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		
		
		// byte 배열을 이용해서 출력하는 스트림 객체 생성 
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		int data;		//읽어온 데이터가 저장될 변수 
		
		// read()메서드 => 더 이상 읽어올 데이터가 없으면 -1을 반환한다. 
		while ((data = input.read()) != -1) {
			// 읽어온 데이터를 처리하는 곳 
			
			output.write(data);								// 출력하기 
			// 읽어올 데이터 없으면 반복문을 빠져나감 
		}
		
		// 출력용 스트림에 출력된 데이터들을 배열로 변환해서 저장하기 
		outSrc = output.toByteArray();				// 출력 스트림 값을 배열로 변환한다.
		
		// 입출력 작업을 모두 마치면 스트림 객체를 닫아줘야한다. ( 사용했던 자원 반납하기 )
		try {
			input.close();
			output.close();
		} catch (IOException e) { }
		
		System.out.println("inSrc   => " + Arrays.toString(inSrc));
		System.out.println("outSrc   => " + Arrays.toString(outSrc));
	}
}
