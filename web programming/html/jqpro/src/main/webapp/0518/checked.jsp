<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
hello! 
<%
	request.setCharacterEncoding("UTF-8");
	String userName = request.getParameter("user");
	String[] hobbies = request.getParameterValues("hobby");
	String str = "";
	for(int i = 0; i < hobbies.length; i++) {
		str += hobbies[i] + " ";
	}
%>
<p> 이름 <%=userName %> </p> 
<p> 취미 <%=str %> </p> 

</body>
</html>