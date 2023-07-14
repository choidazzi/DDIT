<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ page isErrorPage="true"%>
<!doctype html>
<html>
<head>
    <title>Exception</title>
</head>
<body>
<img src="/images/error.gif" alt="error" style="width: 40%">
<p>예외: <%=exception%></p>
<p>toString(): <%=exception.toString()%></p>
<p>getClass(): <%=exception.getClass().getName()%></p>
<p>getMessage(): <%=exception.getMessage()%></p>,
</body>
</html>