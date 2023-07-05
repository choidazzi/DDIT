<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Validation</title>
</head>
<body>
	<form action="" name="frm">
		<p>NAME: <input type="text" name="name" value="1신짱구"></p>
		<!-- checkForm(): 핸들러함수 -->
		<p><input type="button" value="전송" onclick="checkForm()"></p>
	</form>
<script>
	function checkForm() {
		// 이름은 숫자로 시작할 수 없음 
		let str = document.frm.name.value;		//1신짱구 
		// 정규표현식 생성 
		// ^:문자열이 시작 [a-z]: a~z사이의 문자열 중 한 글자 
		let regExp = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		if(!regExp.test(str)) {//테스트 통과 : true, 실패: false
			alert("이름은 숫자로 시작할 수 없습니다.");
			return;	// 함수를 종료 
		}; 
	}
</script>
</body>
</html>