<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Scripting Tag</title>
</head>
<body>
<% // scriptlet tag
	for(int i=0; i<=10; i++) {
		if(i%2 == 0) {
			out.print("<p>" + i + "</p>");
		}
	}
%>
</body>
</html>