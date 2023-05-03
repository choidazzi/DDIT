package kr.or.ddit.basic;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

public class FileIOTest02 {
	//파일에 데이터를 출력하는 예제 - 바이트 기반 스트림 사용 
	public static void main(String[] args) {
		try {
			//파일에 출력할 출력용 바이트 기반 스트림 객체 생성하기 
			FileOutputStream fout = new FileOutputStream("/users/choiseoyeon/d_other/out.txt");
			
			for(char ch = 'A' ; ch <= 'Z'; ch++) {
				fout.write(ch);	//ch 변수의 데이터를 파일로 출력한다.
			}
			System.out.println("출력 작업 완료....");
			
			fout.close();
		} catch (IOException e) {
			System.out.println("입출력 오류 : " + e.getMessage());
		}
	}
}
