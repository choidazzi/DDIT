package chapter15;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class IOEx03 {
	public static void main(String[] args) {
		byte[] inSrc = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		byte[] outSrc = null;
		byte[] temp = new byte[4];

		ByteArrayInputStream input = null;
		ByteArrayOutputStream output = null;

		input = new ByteArrayInputStream(inSrc);
		output = new ByteArrayOutputStream();

		System.out.println("Input Source : " + Arrays.toString(inSrc));

		try {
			// 스트림으로부터 읽어 올 수 있는 데이터의 크기를 반환한다. 
			while (input.available() > 0) {
				input.read(temp);
				output.write(temp);
				System.out.println("temp : " + Arrays.toString(temp));
				
				outSrc = output.toByteArray();
				printArrays(temp, outSrc);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void printArrays(byte[] temp, byte[] outSrc) {
		System.out.println("temp : " + Arrays.toString(temp));
		System.out.println("Output Source : " + Arrays.toString(outSrc));
	}
}

/*
 *마지막 temp 출력 [8,9,6,7]
 *왜냐하면, 보다 나은 성능을 위해 temp에 담긴 내용을 지우고 쓰는 것이 아닌 기존 내용 위에 덮어 쓴다. 
 *이러면 output Source :  [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 6, 7]
 *수정은 IOEx04
 */
