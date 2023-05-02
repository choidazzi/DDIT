package kr.or.ddit.basic;

import java.io.File;

public class FileTest01 {
	public static void main(String[] args) {
		// File 객체 만들기 연습 
		/*
		 		1. new File (String 파일 또는 경로)
		 			=> 디렉토리와 디렉토리 사이 또는 디렉토리와 파일명 사이의 구분문자는 '\' 를 사용하거나 '/'를 사용한다. 
		 	
		 */
		File file1 = new File("/Users/ChoiSeoYeon/D_Other/test.txt");
		
		System.out.println("파일명: " + file1.getName());
		System.out.println("파일 여부: " + file1.isFile());		//파일이면 true 
		System.out.println("디렉토리(폴더) 여부 : " + file1.isDirectory());

		File file2 = new File("/Users/ChoiSeoYeon/D_Other");
		
		System.out.println("파일명: " + file2.getName());
		System.out.println("파일 여부: " + file2.isFile());		//파일이면 true 
		System.out.println("디렉토리(폴더) 여부 : " + file2.isDirectory());
		/*
		 		2. new File (File parent, String child)
		 			=> parent 디렉토리 안에 있는 child 파일 정보를 갖는 파일 객체가 생성된다. 
		 	
		 */
		File file3 = new File(file2,"test.txt");
		System.out.println("파일명: " + file3.getName());
		System.out.println("파일 여부: " + file3.isFile());		//파일이면 true 
		System.out.println("디렉토리(폴더) 여부 : " + file3.isDirectory());
		/*
		 		3. new File (String parent, String child)
		 			=> parent 디렉토리 안에 있는 child 파일 정보를 갖는 파일 객체가 생성된다. 
		 */
		File file4 = new File("d:/d_other","test.txt");
		System.out.println("파일명: " + file4.getName());
		System.out.println("파일 여부: " + file4.isFile());		//파일이면 true 
		System.out.println("디렉토리(폴더) 여부 : " + file4.isDirectory());
		
		//==========================================
		/*
	 		디렉토리(폴더) 만들기
	 		
	 		- mkdir() => File 객체의 경로 중 마지막 위치의 이름과 일치하는 디렉토리를 만든다 
	 						=> 반환값: 만들기 성공 (true) / 실패 (false)
		 */
		
		File file5 = new File("/Users/ChoiSeoYeon/연습용");
		
		// exists() 메서드 => 해당 경로에 파일이나 디렉토리가 있으면 true, 없음녀 false 
		file5.mkdir();
		if (!file5.exists()) {
			if (file5.mkdir()) {
				System.out.println("만들기 성공! ");
			}else {
				System.out.println("만들기 실패!");
			}
		} else {
			System.out.println(file5.getName() + " 이미 존재합니다.");
		}
	}
}
