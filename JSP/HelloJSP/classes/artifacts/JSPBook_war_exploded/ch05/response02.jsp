<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.Date"%>
<!DOCTYPE html>
<html>
<head>
<title>Implicit Objects(내장 객체)</title>
</head>
<body>
	<%//스크립틀릿 
			//1초마다 새로고침 
			//response.setIntHeader("Refresh", 1);
	%>
	<p id="p1"><%=new Date().toLocaleString() %></p>
<script>
function gogo() {
	let today = new Date();
	let year = today.getFullYear();
	let month = ('0' + (today.getMonth() + 1)).slice(-2);
	let day = ('0' + (today.getDate() + 1)).slice(-2);
	let dateString = year + "-" + month + "-" + day;
	
	let hours = ('0' + today.getHours()).slice(-2);
	let minutes = ('0' + today.getMinutes()).slice(-2);
	let seconds = ('0' + today.getSeconds()).slice(-2);
	let timeString = hours + ":" + minutes + ":" + seconds;
	
	document.getElementById('p1').innerHTML = dateString + " " + timeString;
}
setInterval(gogo, 1000);
</script>
</body>
</html>