<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
<%
	// Enumeration 열거형 
	// 모든 헤더의 이름을 가져오기 => 리턴 타입: Enumeration(열거형)
	Enumeration en = request.getHeaderNames();
	// hasMoreElements() : 값이 있을 때에만 반복 
	while(en.hasMoreElements()) {
		// 현재 헤더 이름을 가져옴 (Object => String 으로 downCasting)
		String headerName = (String)en.nextElement();
		// request.getHeader("host");
		String headerValue = request.getHeader(headerName);
		out.print("<h3>" + headerName +" : " + headerValue + "</h3>");
	}

%>
<p>요청 정보 길이: <%=request.getContextPath() %></p>
<p>클라이언트 전송방식: <%=request.getMethod() %></p>
<p>요청 URI: <%=request.getRequestURI() %></p>
<p>서버 이름: <%=request.getServerName()%></p>
<p>서버 포트: <%=request.getServerPort()%></p>
</body>
</html>