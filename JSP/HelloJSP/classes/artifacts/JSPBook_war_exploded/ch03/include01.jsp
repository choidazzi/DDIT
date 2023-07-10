<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Directing Tag</title>
</head>
<body>
<%
	String memId = "다찌";
	
	memId = URLEncoder.encode(memId);
%>
	<!-- header를 인클루드 (외부 파일 가져옴) -->
	<%@ include file = "include01_header.jsp" %>
	<h4>--------현재 페이지 입력--------</h4>
	<!-- footer를 인클루드(외부 파일 가져옴) 
		 JSP내장객체인 request 객체{요청 파라미터: memId = dazzi}에 담김
		 include directive는 요청 파라미터를 못함  
	-->
	<%-- <%@ include file = "include01_footer.jsp?memId="+memId %> --%>
	<!-- 요청 URL: include01_footer.jsp
		 요청 파라미터: memId = dazzi 
		 요청 URI: include01_footer.jsp?memId='dazzi'-->
	<jsp:include page="include01_footer.jsp">
		<jsp:param value="<%=memId %>" name="memId"/>
	</jsp:include>
</body>
</html>