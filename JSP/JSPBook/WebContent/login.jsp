<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<title>Login</title>
</head>
<body>
<!-- include 액션 태그 -->

<jsp:include page="menu.jsp" />

<!-- 로그인 폼 시작 -->
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">Login</h1>
	</div>
</div>
<div class="container" align="center">
	<div class="col-md-4 col-md-offset-4">
		<h3 class="form-signin-heading">Please Sign in</h3>
	</div>
	<%

		//요청 파라미터: login.jsp?error=1
		//로그인(인증 authentication)실패 시 error=1 요청 파라미터의 값을 얻어올 수 있음
		String error = request.getParameter("error");
		if(error!=null) {
			//오류 메시지를 출력.
			out.print("<div class='alert alert-danger'>");
			out.print("아이디와 비밀번호를 확인해주세요.");
			out.print("</div>");
		}
	%>
	<!--p.350
		web.xml에 <auth-method>FORM</auto-method> 설정
		action속성의 값은 j_security_check 로 정해져있음
		j_security_check 톨게이트를 통과해야만 addProduct.jsp(목적지)로 갈 수 있음
	-->
	<form action="j_security_check" class="form-signin" method="post">
		<!-- 아이디 입력 영역, username -->
		<div class="form-group">
			<label for="inputUserName" class="sr-only">UserName</label>
			<input type="text" id="inputUserName" class="form-control" placeholder="Please enter ID"
					name="j_username" required autofocus>
		</div>
		<%-- 비밀번호 입력 영역, j_password도 고정 --%>
		<div class="form-group">
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" class="form-control" placeholder="Please enter Password"
					name="j_password" required autofocus>
		</div>
		<!-- button type="button/submit/reset" -->
		<button type="submit" class="btn btn-lg btn-success btn-block">로그인</button>
	</form>
</div>
<!-- 로그인 폼 끝 -->

<!-- footer -->
<jsp:include page="footer.jsp" />
</body>
</html>