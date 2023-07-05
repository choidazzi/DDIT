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
	요청 방식: post
 -->
	<form name="loginForm" action="validation03_process.jsp" method="post">
		<p>ID: <input type="text" name="id"></p>
		<p>PASSWORD: <input type="password" name="pass"></p>
		<!-- checkLogin(): 핸들러함수 -->
		<p><input type="button" value="전송" onclick="checkLogin()"></p>
	</form>
<script>
	function checkLogin() {
		let form = document.loginForm;
		// 아이디: 4~12자 사이로 입력 
		if (form.id.value.length < 4 || form.id.value.length > 12) {
			alert("아이디는 4~12자 이내로 입력 가능합니다.");
			form.id.select();	//커서를 위치함
			return;	 //false생략 가능. 함수 종료.
		} 
		// 비밀번호: 4자 이상으로 입력 
		// else if 안 쓴 이유? 모두 통과해야 함.
		if(form.pass.value.length < 4){
			alert("비밀번호는 4자 이상으로 입력해야 합니다.");
			form.pass.select();	//커서를 위치함
			return;	 //false생략 가능. 함수 종료.
		}
		// 모두 통과했다면 
		form.submit();	//validation03_process.jsp를 요청 
	}
</script>
</body>
</html>