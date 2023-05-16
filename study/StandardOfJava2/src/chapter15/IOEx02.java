package chapter15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;

public class IOEx02 {
	public static void main(String[] args) {
		byte[] inSrc = {0,1,2,3,4,5,6,7,8,9};
		byte[] outSrc = null;
		byte[] temp = new byte[10];
		
		ByteArrayInputStream input =  null;
		ByteArrayOutputStream output =  null;
		
		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();
		
		// read(byte[] b, int off, int len)	:  최대 len개 byte를 읽어서 배열 b의 지정된 위치(off) 부터 저장한다.
		// 실제로 읽어 올 수 있는 데이터가 len개보다 적을 수 있다.
		// 배열 temp의 0번째 위치부터 저장한다. 
		input.read(temp,0,temp.length);
		// write(byte[] b, int off, int len) : 주어진 배열 b에 저장된 내용 중 off 번 째 부터 len 개 만큼만을 읽어 출력소스에 쓴다.
		// temp[5] 번 째 부터 5개 만큼 읽어 출력소스에 쓴다.
		output.write(temp, 5, 5);
		
		outSrc = output.toByteArray();
		
		System.out.println("InputSource : " + Arrays.toString(inSrc));
		System.out.println("temp			 : " + Arrays.toString(temp));
		System.out.println("OutputSource : " + Arrays.toString(outSrc));
	}
}
