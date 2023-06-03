<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img alt="pingping" src="../../images/pingpinge.png">
<br>
<br>
<%--  <%=request.getContextPath() %> = webapp --%>
<img alt="pingping" src="<%=request.getContextPath() %>/images/ddung.png">
<br>
<br>
<img alt="sponge" src="<%=request.getContextPath() %>/images/imageView.do?fileno=14">
</body>
</html>