<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter</title>
</head>
<body>
<!--
    사용자가 입력한 요청 파라미터
    /filter01_process.jsp
    {id=admin&pass=1234}
-->
<%
    String id = request.getParameter("id");
    String pass = request.getParameter("pass");
%>

<h3>입력된 id값: <%=id%></h3>
<h3>입력된 pass값: <%=pass%></h3>
</body>
</html>
