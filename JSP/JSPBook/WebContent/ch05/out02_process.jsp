<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!--
				요청 URL	: out02_process.jsp
				요청방식	: post
				요청 파라미터(HTTP paramete,QueryString) : {id =  a001, pass - java}  
		  -->
<%
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
%>
<p>ID: <%out.print(id) ;%></p>
<p>PASSWORD <%out.print(pass); %></p>