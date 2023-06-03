<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 서블릿에서 저장한 데이터 꺼내기 
int cnt = (Integer)request.getAttribute("save");
if(cnt>0){	// 성공 
%>
	{
		"flag":"가입성공 "
	}
<%	
}else{		// 실패 
%>
	{
		"flag":"가입실패 "
	}
<%	
}
%>