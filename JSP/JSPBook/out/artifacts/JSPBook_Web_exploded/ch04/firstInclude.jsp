<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<title>Action Tag</title>
</head>
<body>
	<h3>이 파일은 first.jsp입니다.</h3>
	<!-- 
	include 액션 태그: 다른 페이지를 포함  
	요청 URI: second.jsp?date=오늘날짜 
	요청 파라미터(Http파라미터=QueryString) : date=오늘날짜 
	-->
	<hr>
	<%@ include file="second.jsp" %>
	<hr>
	<jsp:include page="second.jsp">
		<jsp:param value="<%=new Date() %>" name="date"/>
	</jsp:include>
	
	<p>===first.jsp의 페이지===</p>
</body>
</html>