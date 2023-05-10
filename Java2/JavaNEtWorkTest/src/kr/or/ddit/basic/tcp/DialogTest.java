package kr.or.ddit.basic.tcp;


import java.awt.Panel;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;


public class DialogTest {
	public static void main(String[] args) {
		// SWIING의 파일 열기, 저장 창 연습
		JFileChooser chooser = new JFileChooser();

		// 선택할 파일의 확장자 설정
		FileNameExtensionFilter txt = new FileNameExtensionFilter("Text파일", "txt");
		FileNameExtensionFilter pdf = new FileNameExtensionFilter("PDF파일", "pdf");
		FileNameExtensionFilter img = new FileNameExtensionFilter("이미지파일", "jpg", "png", "gif");
		FileNameExtensionFilter doc = new FileNameExtensionFilter("문서파일", new String[] { "docx", "doc" });
		
		chooser.addChoosableFileFilter(txt);
		chooser.addChoosableFileFilter(pdf);
		chooser.addChoosableFileFilter(img);
		chooser.addChoosableFileFilter(doc);
		
		chooser.setFileFilter(img); // 확장자 목록 중 기본적으로 선택할 확장자 지정
		chooser.setAcceptAllFileFilterUsed(true); // 모든 파일 목록의 표시 여부를 설정할지(true) 말지(false) 지정
		chooser.setCurrentDirectory(new File("./src/"));
		int result1 = -1;
		
		int result = chooser.showOpenDialog(new Panel()); // 열기용
//		int save = chooser.showSaveDialog(new Panel()); // 저장용

		// 창에서 파일을 선택한 후 '저장' 또는 '열기' 버튼을 눌렀을 때 처리하기
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = chooser.getSelectedFile();
			System.out.println("선택된 파일: " + selectedFile.getAbsolutePath());
		}
		
		
	}
}
	
