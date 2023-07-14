<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%--<%@ page errorPage="exception_error.jsp" %>--%>
<!doctype html>
<html lang="en">
<head>
    <title>Exception</title>
</head>
<body>
    <%
        // POST 방식
        // 요청 URL: exception_process.jsp
        // 요청 parameters: {num1=12&num2=6}
        String num1 = request.getParameter("num1");
        String num2 = request.getParameter("num2");
        // 문자를 숫자로 형변환
        int a = Integer.parseInt(num1);
        int b = Integer.parseInt(num2);
        int c = a / b;
        out.print("<p>" + num1 + "/" + num2 + "=" + c + "</p>");
%>
</body>
</html>