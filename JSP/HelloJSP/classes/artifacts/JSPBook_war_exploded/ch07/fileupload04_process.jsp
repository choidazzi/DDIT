<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.DiskFileUpload"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%//스크립틀릿 
	// 폼페이지에서 전송된 파일을 저장할 서버의 경로를 작성 
	String path = "/Users/ChoiSeoYeon/Downloads";
	
	// Commons-Fileupload.jar를 이용
	// 해당 패키지에 포함되어 있음
	DiskFileUpload upload = new DiskFileUpload();
	
	// 업로드 환경설정 
	upload.setSizeMax(1000000);	// 업로드 가능 최대 크기(1메가)("bytes" => KB => MB => GB)
	upload.setSizeThreshold(4096);// 메모리상에 저장할 최대 크기(bytes)
	upload.setRepositoryPath(path);//업로드될 파일을 임시로 저장할 경로 
	
	// 폼페이지에서 전송된 multipart/form 유형의 요청 파라미터 
	// => parseRequest()메서드로 전달받음 
	List items = upload.parseRequest(request);
	// Iterator 클래스로 변환 
	Iterator params = items.iterator();
	// 폼 페이지에서 전송된 요청 파라미터가 없을 때까지 반복 
	while(params.hasNext()) { 	// 3회 반복 (name, subject, file)
		// params.next()는 Object로 리턴 
		FileItem item = (FileItem)params.next();
		// 요청 파라미터가 일반 데이터인지 
		if(item.isFormField()) {// 일반 데이터 (<input type="text"...)
			String name = item.getFieldName();	// [name=최서연]에서 name
			String value = item.getString("UTF-8");// 파라미터 값. [name=최서연]에서 최서연
			out.print("<p>" + name + " = " + value + "</p>");
		} else {// 파일인지 <input type="file" ...
			String fileFieldName 
				= item.getFieldName(); // 요청 파라미터 이름 [filename=파일객체]에서 filename
			String fileName = item.getName();	// 저장 파일의 이름. P1237.jpg
			//out.print(fileName);
			String contentType = item.getContentType();	//MIME 타입. 콘텐츠 유형.
			// 업로드 대상 => /Users/ChoiSeoYeon/Downloads/filename.jpg
			// 맥은 안잘라도 됨.
			// fileName = fileName.substring(fileName.lastIndexOf("/")+1);
			long fileSize = item.getSize();	// 파일 크기 정도 
			// item(JSP) => MultipartFile(Spring)
			// 이 곳으로 업로드 => /Users/ChoiSeoYeon/Downloads/filename.jpg
			File file = new File(path + "/" + fileName);
			// 설계대로 복사 실행 
			item.write(file);
			
			out.print("<p>------------------------------------</p>");
			out.print("<p>요청 파라미터 이름: "+ fileFieldName + "</p>");	
			out.print("<p>저장 파일 이름: "+ fileName + "</p>");	
			out.print("<p>파일 컨텐츠: "+ contentType + "</p>");	
			out.print("<p>파일 크기: : "+ fileSize + "</p>");	
		}
	}
	
%>