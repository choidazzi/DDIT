package kr.or.ddit.basic.fileupload.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.vo.FileInfoVO;

/*
 * -Servlet 3.0 이상에서는 파일 업로드를 하려면 @MultipartConfig annotation을 설정해야 한다.
 * 
 * -@MultipartConfig annotation에서 설정할 변수들 
 * 		1) location			 ==> 업로드한 파일이 임시적으로 저장될 경로 지정 (기본값: "" => 시스템의 임시파일 저장위치)
 * 
 * 		2) fileSizeThreshod 	 ==> 이 곳에 지정한 값보다 큰 파일이 전송되면 location에 지정한 임시 디렉토리에 
 * 								 파일을 저장해 놓고 처리한다.  (단위: byte, 기본값: 0(무조건 임시 directory를 사용한다.))
 * 		3) maxFileSize 		 ==> 1개 파일의 최대 크기 (단위: byte, 기본값: -1 (무제한))
 * 		4) maxRequestSize	 ==> 서버로 전송되는 request데이터 전체의 최대 크기 (단위: byte, 기본값: -1 (무제한))
 * 									(모든 파일 크기 + form 의 데이터)
 * */
@WebServlet("/fileUpload.do")
@MultipartConfig(
		fileSizeThreshold = 1024*1024*10, // 1메가 (=1024*1024)
		maxFileSize = 1024*1024*30,
		maxRequestSize = 1024*1024*100
		)
public class FileUpload extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/basic/fileUpload/fileUpload.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 업로드된 파일이 저장될 폴더 설정 
		String uploadPath = "/Users/ChoiSeoYeon/web/uploadFiles"; 
		
		// 저장될 폴더가 없으면 새로 만든다. 
		File f = new File(uploadPath);
		if (!f.exists()) {
			f.mkdirs();
		}
		// 파일이 아닌 일반 데이터는 getParameter()메서드나 getParameterValues()메서드를 이용한다.
		String userName = request.getParameter("username");
		
		System.out.println("일반 파라미터 데이터: " + userName);
		
		//==================파일 처리=======================================
		// 수신 받은 파일 데이터 처리하기 시작..
		String fileName = "";	// 파일명이 저장될 변수 선언 
		
		// upload한 파일 목록이 저장될 List객체 생성 
		List<FileInfoVO> fileList = new ArrayList<>();
		
		/*
		 * -Servlet 3.0이상에서 새롭게 추가된 upload 관련 메서드 
		 * 1) request객체.getParts()		==> 전체 Part객체를 Collection객체에 담아서 반환한다.
		 * 2) request객체.getPart("이름")	==> 지정된 '이름'을 갖는 개별 Part객체를 반환한다.
		 * 						"이름"	==> form태그 안의 입력요소의 name 속성값으로 구별한다. 
		 * */
		
		// 전체 Part객체 개수만큼 반복 처리 
		for(Part part: request.getParts()) {
			
		}
	}

}
