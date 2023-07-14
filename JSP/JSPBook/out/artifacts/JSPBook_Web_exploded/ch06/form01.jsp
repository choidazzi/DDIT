<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<h3>회원가입</h3>
	<!-- 폼태그, 폼필드 
	action 생략 시 본인 URL을 요청
	method 생략 시 기본 HTTP요청 방식은 get 
	-->
	<!-- 
		요청URL: form01_process.jsp
		요청방식: post
		요청파라미터(HTTP파라미터=QueryString):
			{id=a001, pass=java, name=최서연, phone=010-1234-5678, 
			gender=female,hobby={reading,exercise}. comment="가입할게요."}
	 -->
	<form action="form01_process.jsp" name="member" method="post" onsubmit="return fn_chk()">
		<!-- 폼 데이터 -->
		<p>아이디: <input type="text" name="id"> </p>		 
		<p>비밀번호: <input type="password" name="pass"></p>		 
		<p>이름: <input type="text" name="name"></p>		 
		<p>연락처: 
			<select name="phone1">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
				<option value="019">019</option>
			</select> 
			- <input type="text" maxlength="4" size="7" name="phone2"
						 onkeypress="checkInputNum()">
			- <input type="text" maxlength="4" size="7" name="phone3"
						 onkeypress="checkInputNum()">
		</p>		 
		<p>성별: 
						<input type="radio" name="gender" value="female" checked> <label for="female">여성</label>
						<input type="radio" name="gender" value="male"> <label for="male">남성</label>
		</p>		 
		<p>취미: 
					<label for="hobby1">독서</label><input type="checkbox" id="hobby1" name="hobby" value="reading">
					<label for="hobby2">코딩</label><input type="checkbox" id="hobby2" name="hobby" value="coding">
					<label for="hobby3">운동</label><input type="checkbox" id="hobby3" name="hobby" value="exercise">
		</p>		 
		<p>
			<!-- rows: 줄 수 / cols: 열 수 -->
			<textarea name="comment" rows="3" cols="30" placeholder="가입인사를 입력해주세요." wrap="soft"></textarea>
		</p>		 
		<p><input type="submit" value="가입하기"> </p>
	</form>
<script>

function fn_chk() {
	let form = document.member;
	//<input type="text" maxlength="4" size="7" name="phone2"
	//isNaN: is Not a Number
	if(isNaN(form.phone2.value)) {
		alert("휴대폰 번호는 숫자만 입력 가능합니다.");
		form.phone2.select();
		//false 면 submit 안 됨
		return false;
	}
	if(isNaN(form.phone3.value)) {
		alert("휴대폰 번호는 숫자만 입력 가능합니다.");
		form.phone2.select();
		//false 면 submit 안 됨
		return false;
	}
	//if 조건을 모두 통과해야 submit됨 ,
	return true;
}
// 숫자만 입력할 수 있도록 처리
function checkInputNum() {
	//48: ascii코드의 0, 
	if (event.keyCode<48 || event.keyCode > 57) {
		event.returnValue = false;
	}
}



</script>
</body>
</html>