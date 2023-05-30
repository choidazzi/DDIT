<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Response Test</title>
</head>
<body>
<h2>forward방식, redirect방식 연습 </h2>
<!-- action = /webTest/responseTest01.do" -->
<form action="<%=request.getContextPath() %>/responseTest01.do" method="post">
	forward방식 요청: <input type="text" name="username">
	<input type="submit" value="확   인">
</form>
<br>
<hr>
<br>

<form action="/webTest/responseTest02.do">
	redirect방식 요청: <input type="text" name="username">
	<input type="submit" value="확   인">
</form>
</body>
</html>