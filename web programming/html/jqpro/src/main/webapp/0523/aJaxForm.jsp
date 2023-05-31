<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
p {
	border: 3px double blue;	
}
</style>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	String userName = request.getParameter("name");
	String userAge = request.getParameter("age");
%>

<p>당신의 이름은 <%= userName%> 이고</p>
<p>당신의 나이는 <%= userAge%> 이군요</p>
</body>
</html>