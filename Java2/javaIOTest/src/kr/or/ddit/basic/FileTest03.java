package kr.or.ddit.basic;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest03 {
	public static void main(String[] args) {
		FileTest03 test = new FileTest03();
		
		File file = new File(".");
		test.displayFileList(file);
	}
	/*
 		디렉토리 정보를 갖는 File 객체를 매개변수로 받아서 해당 디렉토리에 있는 
 		모든 파일과 디렉토리 목록을 출력하는메서드 
	 */
	public void displayFileList(File dir) {
		if (!dir.isDirectory()) {
			System.out.println("디렉토리(폴더)만 가능합니다 ! ");
			return;
		}
		
		System.out.println("[" + dir.getAbsolutePath() + "] 디렉토리 내용 ! ");
		System.out.println();
		
		// 해당 디렉토리 안에 있는 모든 파일과 디렉토리 목록을 구한다. 
		File[] files = dir.listFiles();
		String[] fileStrs = dir.list();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm"); 
		
		
		//가져온 파일과 디렉토리 목록 개수만큼 반복 
		for(int i=0; i<files.length; i++) {
			String fileName = files[i].getName();
			String attr = "";		// 파일의 속성 (읽기, 쓰기, 히든, 디렉토리 구분하기)
			String size = ""; 	// 파일의 크기를 문자열로 저장하기 위한 변수
			
			//lastModified() 메서드		=> 파일 또는 디렉토리(폴더) 의 가장 최근 변경 날짜 
			String date = sdf.format(new Date(files[i].lastModified()));
			
			if(files[i].isDirectory()) {
				attr = "<DIR>";
			} else {
				size = String.valueOf(files[i].length());
				attr = files[i].canRead() ? "R" : "";
				attr += files[i].canWrite() ? "W" : "";
				attr += files[i].isHidden() ? "H" : "";
			}
			
			System.out.printf("%s \t %5s \t %8s \t\t %s \n", date, attr, size, fileName);
		}
	}
}
