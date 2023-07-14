<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
	//setHeader()메서드 : 헤더 이름(name)에 문자열 값을 설정 
	response.setHeader("Cache-control", "use-cache");	
	//addHeader()메서드: 헤더 이름(name)에 값을 설정 
	response.addHeader("contentType", "text/html;charset=utf-8");
	//setDateHeader()메서드: 헤더 이름에 날짜/시간 설정 
	response.setDateHeader("date", 10000L);	// 기본날짜 + 10초 증가 
%>
<p>Cache-control: <%=response.getHeader("Cache-control") %></p>
<p>contentType: <%=response.getHeader("contentType") %></p>
<p>date: <%=response.getHeader("date") %></p>
</body>
</html>