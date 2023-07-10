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
 	<h3>회원 가입</h3>
	<%--
		요청 URL: validation05_process.jsp
		요청 Parameter: {
						id=a001,
						pass=1234,
						name=최서연,
						phone1=010,
						phone2=1234,
						phone3=1234,
						email=test@test.co.kr
						}
		요청 방식: post
	--%>
	<form name="Member" action="validation05_process.jsp" method="post">
		<p>ID: <input type="text" name="id"></p>
		<p>PASSWORD: <input type="password" name="pass"></p>
		<p>NAME: <input type="text" name="name"></p>
		<p>TEL: 
			<select name="phone1">
				<option value="010">010</option>
				<option value="011">011</option>
				<option value="016">016</option>
				<option value="017">017</option>
				<option value="019">019</option>
			</select> - 
			<input type="text" maxlength="4" size="4" name="phone2"> -
			<input type="text" maxlength="4" size="4" name="phone3"> 
		</p>
		<p>이메일: <input type="text" name="email"> </p>
		<!-- checkMember(): 핸들러함수 -->
		<p><input type="button" value="가입하기" onclick="checkMember()"></p>
	</form>
<script>
	function checkMember() {
		 //1) 아이디는 문자로 시작
		 let regExpId = /^[a-z|A-Z|ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		 //2) 이름은 한글만 입력 (시작도 한글 끝도 한글) => ^한글$
		 //		+ : 한 번 이상  
		 //		* : 한 번 이상  
		 let regExpName = /^[가-힣]*$/;
		 //3) 비밀번호는 숫자만 입력 (^숫자$)
		 let regExpPass = /^[0-9]*$/;
		 //4) 연락처 형식 준수 (010-111-2222, 010-1111-2222)
		 // \d: 숫자 
		 // 숫자{3}: 숫자가 3회 반복
		 // \d{3,4} : 숫자가 3이상 4이하 반복 
		 let regExpTel = /^\d{3}-\d{3,4}-\d{4}$/;
		 //5) 이메일 형식 준수 (tester-_.2a@korea_.ac.kr)
		 // ^ : 시작 / $ : 끝 / ? : 있어도 그만 없어도 그만 / * : 0이상 반복 / {2,3} : 2이상 3이하 
		 // [a-z] : a부터 z사이 영소문자 중 한글자 
		 let regExpEmail =
		 /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
		 // form : Object
		 let form = document.Member;
		 let id = form.id.value;
		 let pass = form.pass.value;
		 let name = form.name.value;
		 let tel = form.phone1.value + "-" + form.phone2.value + "-" + form.phone3.value;
		 let email = form.email.value;
		console.log("id : " + id + ", pass : " + pass + ", name : " + name + ", tel : " + tel + ", email : " + email);
		 // 1) 아이디는 문자로 시작 
		if(!regExpId.test(id)) {
			alert("아이디는 문자로 시작해주세요.");
			form.id.select();
			return;
		}
		// 2) 이름은 한글만 입력 
		if(!regExpName.test(name)) {
			alert("이름은 한글로 입력해주세요.");
			form.name.select();
			return;
		} 
		// 3) 비밀번호는 숫자만 입력 
		if(!regExpPass.test(pass)) {
			alert("비밀번호는 숫자로 시작해주세요.");
			form.pass.select();
			return;
		} 
		// 4) 연락처 형식 준수 
		if(!regExpTel.test(tel)) {
			alert("연락처를 확인해주세요.");
			return;
		} 
		// 5) 이메일 형식 준수 
		if(!regExpEmail.test(email)) {
			alert("이메일 형식을 확인해주세요.");
			form.email.select();
			return;
		} 
		// 유효성 검사(validation) 통과 
		form.submit();
	}
</script>
</body>
</html>