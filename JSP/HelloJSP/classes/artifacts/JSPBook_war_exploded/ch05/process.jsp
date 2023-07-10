<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- 
	요청 URL			 	: process.jsp
	요청 Parameter	: {name = 최서연}  
 -->
<%
	request.setCharacterEncoding("UTF-8");
	//request 내장 객체가 {name = 최서연} 요청 파라미터를 갖고 있음 
	String name = request.getParameter("name");	//최서연	
%>
<p>이름: <%=name%></p>

<!-- JSTL 변수 name -->
<c:set var="name" value="<%=name %>"/>
<p>이름(JSTL) : ${name} </p>

<!-- Java Script 변수 name -->
<script>
	let name = "${name}";
	console.log("name: " + name);
</script>