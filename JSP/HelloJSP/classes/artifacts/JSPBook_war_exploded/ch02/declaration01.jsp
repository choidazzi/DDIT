<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Scripting Tag</title>
</head>
<body>
<!-- 선언문 태그. 정수형 변수 data에 50을 할당(대입) -->
<%! 
	int data = 50;
%>
<% // 스크립틀릿 태그 
	out.print("data: " + data);
%>
</body>
</html>