<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	String memId = request.getParameter("memId");
	memId = URLDecoder.decode(memId);
%>


Copyright &copy; <%= memId %>