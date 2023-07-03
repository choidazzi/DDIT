<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<title>Implicit Object (내장 객체)</title>
</head>
<body>
<%
		out.print("오늘의 날씨 및 시간 :  <br/>");
		out.println("<p>" + Calendar.getInstance().getTime() + "</p>");//시간 
		out.print("최다찌");
		
%>
</body>
</html>