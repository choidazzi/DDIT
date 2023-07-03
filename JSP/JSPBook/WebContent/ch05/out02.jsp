<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<title>Implicit Object (내장 객체)</title>
</head>
<body>
		<!-- 폼 필드 -->
		<!--
				요청 URL	: out02_process.jsp
				요청방식	: post
				요청 파라미터(HTTP paramete,QueryString) : {id =  a001, pass - java}  
		  -->
		<form action="out02_process.jsp" method="post">
		<!-- 
			폼 데이터
			필수 : mandatory
		-->
		<p>ID : <input type="text" name="id" required placeholder="id"></p>
		<p>PASSWORD : <input type="text" name="pass" required placeholder="password"></p>
		<button type="submit">SUBMIT</button>
		</form>
</body>
</html>