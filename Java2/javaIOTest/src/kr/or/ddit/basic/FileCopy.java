package kr.or.ddit.basic;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 	/users/choiseoyeon/d_other 폴더에 있는 'heart.png' 파일을 
 	/users/choiseoyeon/d_other/연습용 폴더에 'heart_복사본.png' 파일로 
 	 복사하는 프로그램을 작성하시오. 
 * */
public class FileCopy {
	public static void main(String[] args) {
		
		File file = new File("/users/choiseoyeon/d_other/heart.png");
		
		if (!file.exists()) {
			System.out.println(file.getName() + "파일이 없습니다...");
			System.out.println("복사작업을 중지합니다.");
			return;
		}
		System.out.println("복사 작업 시작! ^__^");
		try {
			//원본 파일을 읽어올 스트림 객체 
			FileInputStream fin = new FileInputStream("/users/choiseoyeon/d_other/heart.png");
			BufferedInputStream bin = new BufferedInputStream(fin);
			
			//대상 파일에 저장할 스트림 객체 생성 
			FileOutputStream fout = new FileOutputStream("/users/choiseoyeon/d_other/연습용/heart_복사본.png");
			BufferedOutputStream bout = new BufferedOutputStream(fout);
			
			//읽어온 데이터가 저장될 변수 
			int data;
			/*
			while((data=fin.read()) != -1) {
				fout.write(data);
			}
			
			//스트림 닫기 
			fin.close();
			fout.close();
			*/
			
			while ((data=bin.read()) != -1) {
				bout.write(data);
			}
			bin.close();
			bout.close();
			System.out.println("복사 작업 완료! ^__^");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
