<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter</title>
</head>
<body>
  <!--
      요청 URL: /ch12/filter01_process.jsp
      요청 Parameters: {name=최서연}
   -->
  <%
    String name = request.getParameter("name");//최서연
  %>
  <!--
    1) /ch12/filter01_process.jsp?name=최서연
      => 입력된 name값: 최서연
    2) /ch12/filter01_process.jsp?name=
      => 입력된 name값은 null입니다.
  -->
  <h3>입력된 name값: <%=name%></h3>
</body>
</html>
