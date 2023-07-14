<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<h3>입력에 성공했습니다.</h3>
<!-- 
	body와 body 사이를 document라고 함 
	요청 URL: validation_process.jsp
	요청 파라미터(HTTP파라미터, QueryString) : {id=a001, pass=java}
	요청 방식: post
-->
<%
	// 문자 인코딩 유형 처리 
	request.setCharacterEncoding("UTF-8");
	// request객체: JSP 내장 객체 (session,application, out, response, pageContext...)
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
%>
<p>ID: <%=id %></p>
<p>PASSWORD: <%=pass %></p>