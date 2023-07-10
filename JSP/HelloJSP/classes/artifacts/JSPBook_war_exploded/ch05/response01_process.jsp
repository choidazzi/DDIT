<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	String id = request.getParameter("id");			// a001
	String pass = request.getParameter("pass");	// java
	
	//분기 
	if(id.equals("a001") && pass.equals("java")) { // 관리자 
		response.sendRedirect("response01_success.jsp");
	} else {	//관리자가 아님
		response.sendRedirect("response01_failed.jsp");
	}
%>