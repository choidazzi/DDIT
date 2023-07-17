<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
  <h3>Session 중 특정 세션만 삭제해보자.</h3>
  <!--
    session01.jsp와 session01_process02.jsp를 먼저 수행 후
    session.setAttribute("userId", "admin");
    session.setAttribute("userPwd", "java");
  -->
  <h3>세션 삭제 전</h3>
  <%
    String userId = (String) session.getAttribute("userId");
    String userPw = (String) session.getAttribute("userPw");
    out.print("설정된 세션이름 userId: " + userId +"<br/>");
    out.print("설정된 세션이름 userPwd: " + userPw);

    //세션의 속성 중 userId 속성을 제거 (잘 안씀)
    session.removeAttribute("userId");
    userId = (String) session.getAttribute("userId");
    userPw = (String) session.getAttribute("userPw");
    out.print("<h3>세션 삭제 후</h3>");
    out.print("설정된 세션이름 userId: " + userId +"<br/>");
    out.print("설정된 세션이름 userPwd: " + userPw);
  %>
</body>
</html>
