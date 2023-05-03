package kr.or.ddit.basic;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class ByteArrayIOTest02 {
	public static void main(String[] args) {
		
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;
		byte[] temp = new byte[4];
		
		// byte 배열을 이용해서 입력하는 스트림 객체 생성 
		ByteArrayInputStream input = new ByteArrayInputStream(inSrc);
		
		
		// byte 배열을 이용해서 출력하는 스트림 객체 생성 
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		
		try {
			while(true) {
				
				//input.available()		=> 남아있는 데이터 중 읽어올 수 있는 개수를 반환한다. 
				if (input.available() <= 0 ) {
					break;
				}
				/*
				input.read(temp);
				
				output.write(temp);
				*/
				
				//read(배열) 메서드=> 실제 읽어온 개수를 반환한다. 
				int len = input.read(temp);					//실제 읽어온 데이터의 개수를 구한다 (=> read(배열) 메서드에서 실제 읽어온 개수를 반한다)
				
				//temp배열의 내용 중에서 0 번째부터 len 개수만큼 출력한다.
				output.write(temp, 0 , len);
				System.out.println();
				System.out.println("반복문 안에서 temp : " + Arrays.toString(temp));
			}
			
			outSrc = output.toByteArray();
			
			input.close();
			output.close();
			
			System.out.println("inSrc   => " + Arrays.toString(inSrc));
			System.out.println("outSrc   => " + Arrays.toString(outSrc));
			
		} catch (IOException e) { }
	}
}
