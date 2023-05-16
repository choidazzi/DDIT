package chapter15;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamEx1 {
	public static void main(String[] args) {
		try {
			FileOutputStream fos = new FileOutputStream("123.txt");
			// 버퍼의 크기를 5로 한다.
			BufferedOutputStream bos = new BufferedOutputStream(fos,5); 
			for (int i = '1'; i <= '9'; i++) {
				bos.write(i);
			}
			fos.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
