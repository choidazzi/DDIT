<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Scripting Tag</title>
</head>
<body>
<!-- 선언문 태그. 정수형 변수 data에 50을 할당(대입) -->
<%!
int sum(int a, int b) {
	// a, b : 정수형 매개변수 
	// 리턴타입(정수형)
	// 전역 메서드 
	return a+b;
}

%>
<% // 스크립틀릿 태그 
	// sum이라는 전역 메서드를 호출 (두 개의 파라미터 전달)
	out.println("2 + 3 = " + sum(2,3));
%>
</body>
</html>