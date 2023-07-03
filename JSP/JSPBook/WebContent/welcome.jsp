<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
// out.print(greeting);
// out.print(test);	// 문제발생!
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<!--//////////////////////////header 시작(menu.jsp)///////////////////////  -->
	<%@ include file="menu.jsp" %>
<!--//////////////////////////header 끝///////////////////////  -->
	
	<%!	// 선언문(전역변수)
		String greeting = "Welcome to 최서연 World";
		String tagline = "Welcome to 서연이 Market!";
	%>
	<c:set var="tagline" value="<%=tagline %>"></c:set>
	<div class="jumbotron">
		<div class="container" style="text-align: center;">
			<h1 class="display-3">
				<%= greeting %>
			</h1>
		</div>
	</div>
	<div class="container">
		<div class="text-center">
			<h3 id="clock">
				<%
					Date day = new Date();
				
					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
					String CC = formatter.format(day);
					// 지역변수 
					String am_pm;
					int hour = day.getHours();
					int minute = day.getMinutes();
					int second = day.getSeconds();
					/* 
					if(hour/12 == 0) { // 0 ~ 11 => 0 정수/정수 => 정수
						am_pm = "AM";
					} else { // 12 ~ 24 =>1 또는 2 
						am_pm = "PM";
						// 13 ~ 23시이면 1~11로 표현
						hour = hour - 12;
					}
					 */
					String CT = hour + ":" + minute + ":" + second
								+ " "; //+ am_pm;
					// JSP의 기본 내장 객체 중 화면에 출력 
					out.print(tagline + " 현재 접속 시각: " + CC +  " " +CT + "<br />");
				%>
			</h3>
		</div>
	</div>
	<!-- footer시작 -->
	<footer class="container">
		<p>&copy;WebMarket</p>
	</footer>
	<!-- footer끝 -->
	<%
		String test = "개똥이";
	%>
<%-- 	<h1><%= greeting %></h1>
	<h3><%= tagline %></h3> --%>
<script>
	function gogo() {
		let tagline = "${tagline}";
		let today = new Date();
		let year = today.getFullYear();
		let month = ('0' + (today.getMonth() + 1)).slice(-2);
		let day = ('0' + today.getDate()).slice(-2);
		let dateString = year + "-" + month + "-" + day;
		
		let hours = ('0' + today.getHours()).slice(-2);
		let minutes = ('0' + today.getMinutes()).slice(-2);
		let seconds = ('0' + today.getSeconds()).slice(-2);
		let timeString = hours + ":" + minutes + ":" + seconds;
		
		document.getElementById('clock').innerHTML 
							= tagline +" 현재 접속 시각: "
												+ dateString + " " + timeString ;
	}
	setInterval(gogo, 1000);
</script>
</body>
</html>