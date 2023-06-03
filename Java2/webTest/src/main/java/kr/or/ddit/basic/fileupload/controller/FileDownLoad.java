package kr.or.ddit.basic.fileupload.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.basic.fileupload.service.FileInfoServiceImpl;
import kr.or.ddit.basic.fileupload.service.IFileInfoService;
import kr.or.ddit.vo.FileInfoVO;

/**
 * Servlet implementation class FileDownLoad
 */
@WebServlet("/fileDownLoad.do")
public class FileDownLoad extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//파라미터로 넘어온 파일번호를 구한다.
		String strFileno = request.getParameter("fileno");
		int fileNo = Integer.parseInt(strFileno);
		
		// 파일 번호를 이용하여 해당 파일 정보를 DB에서 가져온다.
		IFileInfoService service = FileInfoServiceImpl.getInstance();
		FileInfoVO fvo = service.getFileinfo(fileNo);
		
		//파일이 저장된 폴더 설정 
		String uploadPath = "/Users/ChoiSeoYeon/web/uploadFiles";
		
		File f = new File(uploadPath);
		if(!f.exists()) {
			f.mkdirs();
		}
		response.setCharacterEncoding("utf-8");
		
		// 다운 받을 파일명을 이용한 File객체 생성 
		File downFile = new File(uploadPath, fvo.getSave_file_name());
		
		if(downFile.exists()) {		// 해당 파일이 있을 때...
			// contentType 설정 
			response.setContentType("application/octet-stream; charset=utf-8");
			
			// Response객체의 Header에 content-disposition속성을 설정한다.
			String headerkey = "content-disposition";
			
			//content-disposition헤더값으로 다운 받을 파일명을 지정해준다.
			//				==> 원래의 파일명으로 지정해준다.
//			String headerValue = "attachment; filename=\""+fvo.getOrigin_file_name()+"\"";
			String headerValue = "attachment;" + getEncodedFileName(request,fvo.getOrigin_file_name()); 
			
			response.setHeader(headerkey, headerValue); //헤더 설정 
			//파일 입출력을 진행한다.
			BufferedInputStream bin = null;
			BufferedOutputStream bout = null;
			
			try {
				//출력용 스트림 객체 생성 (클라이언트로 전송할 스트림)	==> response객체 이용 
				bout = new BufferedOutputStream(response.getOutputStream());
				
				// 파일 입력용 스트림 객체 생성 
				bin = new BufferedInputStream(new FileInputStream(downFile));
				
				byte[] temp = new byte[1024];
				int len = 0;
				
				while((len=bin.read(temp))>0) {
					bout.write(temp,0,len);
				}
				bout.flush();
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("I/O ERROR : " + e.getMessage());
			} finally {
				if(bin!=null) try {bin.close();} catch (IOException e) { }
				if(bout!=null) try {bin.close();} catch (IOException e) { }
			}
			
		} else {		// 해당 파일이 없을 때...
			response.setContentType("text/html; charset=utf-8");
			response.getWriter().println("<h3>"+fvo.getOrigin_file_name()+" 파일이 존재하지 않습니다.</h3>");
		}
		
	}

 	  // 다운로드할 파일명에 한글이 포함될 경우 한글이 깨지는 것을 방지하는 메서드 
private String getEncodedFileName(HttpServletRequest request, String filename) {
	 String encodedFileName = "";		// 인코딩된 파일명이 저장될 변수 선언 
	 
	 // 웹브라우저 종류별로 처리하기 
	 String userAgent = request.getHeader("user-agent");
	 
	 try {
		//IE10 버전 이하의 웹브라우저 처리 
		 if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
			 encodedFileName = "filename=\""+ URLEncoder.encode(filename,"utf-8").replaceAll("\\+","\\ ")+"\""; //+ : 띄어쓰기 의미 
		} else {	// 그 외의 웹 브라우저 
			encodedFileName = "filename*=UTF-8''" +
						URLEncoder.encode(filename,"utf-8").replaceAll("\\+","%20");
		}
	} catch (Exception e) {
		// TODO: handle exception
		throw new RuntimeException("지원하지 않는 인코딩 방식입니다.");
	}
	 return encodedFileName;
}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
