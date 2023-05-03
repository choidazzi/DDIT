package kr.or.ddit.basic;

import java.io.FileReader;
import java.io.IOException;

public class FileIOTest03 {
	public static void main(String[] args) {
		//문자 기반의 파일 입력용 스트림을 이용한 파일 내용 읽기 예제 
		try {
			//파일 입력용 문자 기반 스트림 객체 생성 
			FileReader fr = new FileReader("/users/choiseoyeon/d_other/test.txt");
			
			int c;
			
			while ((c=fr.read()) != -1) {
				System.out.print((char)c);
			}
			
			fr.close();	// 스트림 닫기 
		} catch (IOException e) {
			System.out.println("입출력 오류 : " + e.getMessage());
		}
	}
}
