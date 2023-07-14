<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
</head>
<body>
	<form action="" name="loginForm">
		<p>ID: <input type="text" name="id"></p>
		<p>PASSWORD: <input type="password" name="pass"></p>
		<!-- checkform(): 핸들러함수 -->
		<p><input type="button" value="전송" onclick="checkform()"></p>
	</form>
<script>
	function checkform() {
		// body와 body사이를 document라고 함 
		// name 으로 접근 
		let id = document.loginForm.id.value;	// a001 
		let pass = document.loginForm.pass.value;	// java
		console.log("id: " + id + ", pass: "+ pass);
	}
</script>
</body>
</html>