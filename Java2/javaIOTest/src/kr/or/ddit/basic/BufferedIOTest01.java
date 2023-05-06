package kr.or.ddit.basic;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class BufferedIOTest01 {
	public static void main(String[] args) {
		// 입출력의 성능 향상을 위해서 Buffered스트림을 사용한다.
		
		// 출력용 Buffered 스트림 사용 예제 
		try {
			FileOutputStream fout = new FileOutputStream("/users/choiseoyeon/d_other/buffertest.txt");
			
			// 버퍼의 크기가 5일 Buffered 스트림 객체 생성 
			BufferedOutputStream bout = new BufferedOutputStream(fout, 5);
			
			for(int i = '1'; i <= '9'; i++) {
				bout.write(i);
			}
			//버퍼에 남아있는 데이터를 모두 출력 장치로 출력시킨다. 
			//bout.flush();
			
			//fout.close();
			//보조 스트림을 닫으면 보조스트림에서 사용한 기반이 되는 스트림도자동으로 닫힌다.
			//버퍼 스트림의 close()메서드에서는 flush() 기능이 포함되어 있다. 
			bout.close();
			
			System.out.println("작업 끝...");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
