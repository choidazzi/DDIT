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
  <form action="/ch12/filter01_process.jsp" method="post">
    <p>이름: <input type="text" name="name"/></p>
    <p><input type="submit" value="전송"/></p>
  </form>
</body>
</html>
