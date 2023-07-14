<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
  <%
    //리턴타입은 Object이므로 하위의 String타입으로 다운캐스팅
    String id = (String)session.getAttribute("userId");
    String pw = (String)session.getAttribute("userPw");

    out.print("설정된 세션의 속성 값[1]: " + id + "<br/>");
    out.print("설정된 세션의 속성 값[2]: " + pw + "<br/>");
  %>
</body>
</html>
