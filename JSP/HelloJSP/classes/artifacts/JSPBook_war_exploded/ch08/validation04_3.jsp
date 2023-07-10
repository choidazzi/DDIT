<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
</head>
<body>
	<form action="" name="frm">
		<p>NAME: <input type="text" name="name" value="Java Server Page"></p>
		<!-- checkForm(): 핸들러함수 -->
		<p><input type="button" value="전송" onclick="checkForm()"></p>
	</form>
<script>
	function checkForm() {
		// 정규 표현식 선언 /로 시작, /로 닫음
		let regExp = /Java/i;	// i: ignore 대소문자를 구별하지 않음 
		let str = document.frm.name.value; //Java Server Page
		let result = regExp.exec(str);	// str에서 regExp 글자 찾음 (추출)
		//result = Java
		console.log("result: " + result);
	}
</script>
</body>
</html>