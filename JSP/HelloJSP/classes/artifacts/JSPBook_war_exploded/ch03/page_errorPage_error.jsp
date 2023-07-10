<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isErrorPage = "true" %>
<!DOCTYPE html>
<html>
<head>
<title>서비스 문제 발생</title>
</head>
<body>
	<!-- /images: webContent > -->
	<img alt="" src="/images/error.jpg">
	<%
		//exception 내장객체 (isErrorPage = "true" 일 떄 활성화) 
		exception.printStackTrace(new PrintWriter(out));
		
	%>
</body>
</html>