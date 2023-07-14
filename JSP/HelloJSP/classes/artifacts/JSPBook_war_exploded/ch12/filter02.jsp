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
  <form action="filter02_process.jsp" method="post">
    <p>아이디: <input type="text" name="id"></p>
    <p>비밀번호: <input type="password" name="pass"></p>
    <p><input type="submit" value="전송"></p>
  </form>
</body>
</html>
