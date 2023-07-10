<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>File Upload</title>
</head>
<body>
<!-- 
	파일 업로드 패키지인 Commons-FileUpload는 서버의 메모리상에서 파일 처리가 가능하도록 지원함 
	이 패키지는 Commons-io 패키지를 바탕으로 작성되었으므로 웹 브라우저(크롬)에서 서버(톰켓)로 
	파일을 업로드하기 위해 오픈 라이브러리 commons-fileupload.jar, commons-io.jar파일을 사용 
	JSP 페이지에 page 디렉티브 태그의 import 속성을 사용하여 패키지를 임포트 함.
	lib 폴더에 해당 jar를 넣어주면 됨 
 -->
 <!-- 
 	파일 업로드를 위한 폼 태그에 method 속성 값은 Post,
 	enctype 속성 값은 multipart/form-data,
 	업로드된 파일을 처리하기 위한 action 속성 값을 작성 
 	<input type="file... 
  -->
 <form action="fileupload03_process.jsp" method="post"
 			enctype="multipart/form-data">
 	<!-- 파일을 입력받도록 input 태그의 type속성 값을 file로 작성하고, name속성을 작성함 -->
 	<p>파일: <input type="file" name="filename"></p>
 	<!-- 입력된 데이터를 서버로 전송하도록 input 태그의 type속성 값을 submit으로 작성-->
 	<p><input type="submit" value="Upload File"></p>
 </form>
</body>
</html>