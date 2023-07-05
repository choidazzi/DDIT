<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
</head>
<body>
	<form action="" name="frm">
		<p>NAME: <input type="text" name="name"></p>
		<!-- checkForm(): 핸들러함수 -->
		<p><input type="button" value="전송" onclick="checkForm()"></p>
	</form>
<script>
	function checkForm() {
		// 1admin
		// 3서연
		// It is Not a Number: 그것은 숫자가 아니다(isNaN)
		let form = document.frm;
		if (!isNaN(form.name.value.substr(0,1))) { // 이름의 첫글자가 숫자면 
			alert("이름은 숫자로 시작할 수 없습니다.");
			form.name.select();
			return;
		}
		// 통과했다면 
		form.submit();	// form에 action없음 => 현재 URL을 요청, method없음 => 기본 get방식 
	}
</script>
</body>
</html>