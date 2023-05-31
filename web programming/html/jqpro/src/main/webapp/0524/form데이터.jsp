<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
 	// 전송 시 데이터를 받는다 
	request.setCharacterEncoding("UTF-8");

	String userName = request.getParameter("name");
	String userAge = request.getParameter("age");
 	// DB 처리 수행 
 	
 	// 수행 결과를 얻는다
 	
 	// 수행 결과로 응답 데이터를 생성 - text  
    %>
    
    {
    	"name" : "<%= userName %>",
    	"age": "<%= userAge %>"
    }