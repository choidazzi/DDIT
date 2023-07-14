<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Exception</title>
</head>
<body>
  <!--
    * POST 방식
    요청 URL        : exception_process.jsp
    요청 parameters : {num=12&num2=6n}
    * GET 방식
    요청 URL        : exception_process.jsp?num1=12&num2=6n
    요청 parameters : num1=12&num2=6n
  -->
  <form action="tryCatch_process.jsp" method="post">
    <p>숫자1: <input type="text" name="num1"></p>
    <p>숫자2: <input type="text" name="num2"></p>
    <p><input type="submit" value="DIVIDE"></p>
  </form>
</body>
</html>
