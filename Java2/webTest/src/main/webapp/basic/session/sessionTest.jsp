<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Session 연습</h2> <hr>
	<a href="<%= request.getContextPath() %>/sessionAdd.do">Session 정보 저장하기</a>
	<a href="<%= request.getContextPath() %>/sessionRead.do">Session 정보 읽어오기</a>
	<a href="<%= request.getContextPath() %>/sessionDelete.do">Session 정보 삭제하기</a>
</body>
</html>