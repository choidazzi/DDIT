<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
</head>
<body>
<!-- 
	body와 body 사이를 document라고 함 
	요청 URL: validation_process.jsp
	요청 파라미터(HTTP파라미터, QueryString) : {id=a001, pass=java}
 -->
	<form name="loginForm" action="validation_process.jsp" method="post">
		<p>ID: <input type="text" name="id"></p>
		<p>PASSWORD: <input type="password" name="pass"></p>
		<!-- checkLogin(): 핸들러함수 -->
		<p><input type="button" value="전송" onclick="checkLogin()"></p>
	</form>
<script>
	// 핸들러 함수 
	function checkLogin() {
		let form = document.loginForm;
		if(form.id.value == "") {
			alert("아이디를 입력해주세요.")
			form.id.focus();		// 해당 입력 항목에 커서가 위치함 
			return false;		// 함수 멈춤 
		} else if (form.pass.value == ""){
			alert("비밀번호를 입력해주세요.")
			form.pass.focus();		// 해당 입력 항목에 커서가 위치함 
			return false;		// 함수 멈춤 
		}
		// 위의 분기문을 잘 통과했다면...
		form.submit();			// validation_process.jsp를 요청 
	}
</script>
</body>
</html>