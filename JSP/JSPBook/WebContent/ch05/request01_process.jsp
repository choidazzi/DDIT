<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 
	요청 URL			 	: request01_process.jsp
	요청 Parameter	: {id=a001&pass=java}  
 -->
<% // 스크립틀릿 
	request.setCharacterEncoding("UTF-8");
	String id = request.getParameter("id");			//a001	
	String pass = request.getParameter("pass");	//java
	
	// 헤더에 있는 host라는 name에 매핑되어있는 값 가져오기 
	String hostValue = request.getHeader("host");
	
	// 헤더에 있는 accept-language라는 name에 매핑되어있는 값 가져오기 
	String alValue = request.getHeader("accept-language");
%>
<p>아이디: <%=id%></p>
<p>비밀번호: <%=pass%></p>
<p>누구니 넌?: <%=hostValue%></p>
<p>어떤 언어 쓰니?: <%=alValue%></p>
<a href="request02.jsp">모든 헤더 정보 가져오기</a>
<!-- JSTL 변수 name -->
<c:set var="id" value="<%=id %>"/>
<c:set var="pass" value="<%=pass %>"/>
<p>아이디(JSTL) : ${id} </p>
<p>비밀번호(JSTL) : ${pass} </p>

<!-- Java Script 변수 name -->
<script>
	let id = "${id}";
	let pass = "${pass}";
	console.log("id: " + id);
	console.log("pass: " + pass);
</script>