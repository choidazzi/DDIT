<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- c는 core의 약자 -->
<!DOCTYPE html>
<html>
<head>
<title>Directives Tag</title>
</head>
<body>
<!-- 
	var: JSTL 변수 
	value: 값
	scope: 활용범위
	(page(동일jsp)/request(동일요청)/session(동일 웹브라우저)/application(모든 웹브라우저))

 -->
 <%
 // JAVAQUSTN 
 String memId = "다찌";
 %>
 <!-- JSTL 변수  -->
<c:set var="memId" value="<%=memId %>" scope="page"></c:set>
<p>${memId}</p>
<p><%=memId %></p>
</body>
</html>