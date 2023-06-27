<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Directive Tag</title>
</head>
<body>
<%@include file="header.jsp" %>

<p>현재 날짜: <%= new Date() %></p>
</body>
</html>