<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exception</title>
</head>
<body>
  <h3>잘못된 데이터가 입력되었습니다.</h3>
  <p>숫자1: <%=request.getParameter("num1")%></p>
  <p>숫자2: <%=request.getParameter("num2")%></p>
</body>
</html>
