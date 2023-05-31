<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//JSP 문서에서 session객체는 'session'이라는 이름으로 이미 저장되어 있다. 
	// 로그인에 성공했을 때 저장한 session데이터 가져오기 
	MemberVO memVo = (MemberVO) session.getAttribute("loginMember");	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session Login</title>
</head>
<body>
<%
	if(memVo == null) {	//로그인이 안되었을 때...
%>	
	<form action="<%= request.getContextPath() %>/sessionLoginDB.do">
		<table border="1" style="margin: 0 auto;">
			<tr>
			   <td>ID: </td>
			   <td><input type="text" name="userid" value="" placeholder="ID 입력하세요."></td>
			</tr>   
			<tr>
			   <td>PASS: </td>
			   <td><input type="password" name="pass" placeholder="password 입력하세요"></td>
			</tr>   
			<tr>
			   <td colspan="2"><input type="checkbox" name="chkid" value="check" checked>id 기억하기</td>
			</tr>   
			<tr>
			   <td colspan="2" style="text-align:center;"><input type="submit" value="login"></td>
			</tr>   
		</table>
	</form>
<%
	} else {
%>
	<h3><%= memVo.getMem_name() %> 님 반갑습니다.</h3>
	<a href="<%= request.getContextPath()%>/sessionLogoutDB.do">LOGOUT</a>
<% 
	}
%> 
</body>
</html>