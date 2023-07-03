<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%//스크립틀릿 
	// 폼페이지에서 전송된 파일을 저장할 서버의 경로를 작성 
	// /Users/ChoiSeoYeon/Downloads
	String fileUploadPath = "/Users/ChoiSeoYeon/Downloads";
	// Commons-FileUpload 라이브러리 패키지에 포함되어 있는 
	// DiskFileuplooad의 instance를 생성  
	DiskFileUpload upload = new DiskFileUpload();
	// 웹 브라우저(크롬)가 전송한 multipart/form 유형의 요청 파라미터들을 가져옴
	// parse(파싱): 구문분석, 의미분석 
	List items = upload.parseRequest(request);
	// 폼 페이지에서 전송된 요청 파라미터를 Iterator클래스로 변환 
	Iterator params = items.iterator();
	// 폼 페이지에서 전송된 요청 파라미터가 더이상 없을 때 까지 반복  
	while(params.hasNext()) {
		// params.next()의 리턴 타입은 Object이므로 FileItem 타입으로 형변환 
		FileItem fileItem = (FileItem)params.next();
		// FileItem클래스의 메서드를 사용하여 요청 파라미터가 
		// 일반 데이터인지 분석 및 처리하여  
		// 파일을 업로드 함 
		// FormField : <input type="text", <input type="radio", <select ...
		if(!fileItem.isFormField()){
			// 파일명 가져옴
			// /Users/ChoiSeoYeon/Downloads/cloud.03.jpg
			String fileName = fileItem.getName();
			out.print(fileName);
			
			//fileName.substring(fileName.lastIndexOf("/")+1);
			
			// 이 곳으로 업로드 => /Users/ChoiSeoYeon/Downloads + /cloud.03.jpg
			File file = new File(fileUploadPath + "/" + fileName);
			//설계대로 복사 실행 
			fileItem.write(file); 
		}
	}

%>