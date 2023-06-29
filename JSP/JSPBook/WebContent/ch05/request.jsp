<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Implicit Objects(내장 객체)</title>
</head>
<body>
	<!-- 
	요청 URL			 	: process.jsp
	요청 Parameter	: {name = 최서연}  
	-->
	<form action="process.jsp" method="post">
			<p>
					이름: 
					<input type="text" name="name" placeholder="이름을 입력해주세요."
						required/>
					<input type="submit" value="전송"/>
			</p>
	</form>
</body>
</html>