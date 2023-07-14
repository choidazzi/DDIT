<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Security</title>
</head>
<body>
  <form name="loginForm" action="j_security_check" method="post">
    <p>ID: <input type="text" name="j_username" > </p>
    <p>PASSWORD: <input type="password" name="j_password" > </p>
    <p><input type="submit" value="Log in"> </p>
  </form>
</body>
</html>
