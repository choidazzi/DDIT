<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Scripting Tag</title>
</head>
<body>
<%! // 선언문 태그 
	int mul(int i, int j) {
		return i * j;
	}
%>
<%  // 전역메서드를 호출 
	for(int i=2; i<=9; i++){
		for(int j=1; j<=9; j++) {
			out.print("<p>" + i + "X" + j + "= " + mul(i,j) + "</p>");
			
		}
	}
%>
</body>
</html>