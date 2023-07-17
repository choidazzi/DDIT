<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
  <h3>세션에 저장된 모든 세션 속성을 삭제 (로그아웃 기능 구현시 많이 사용)</h3>
  <h4>세션 삭제전 (p.430)</h4>
  <%
    String userId = (String) session.getAttribute("userId");
    String userPw = (String) session.getAttribute("userPw");
    out.print("getId: " + session.getId());

    //클라이언트가 가지고 있는 세션이 유효한지(있는지) 체크
    if (request.isRequestedSessionIdValid()==true) {
      out.print("<p>세션이 유효합니다.(있다)</p>");
    } else {
      out.print("<p>세션이 유효하지 않습니다.(없다)");
    }

    //세션에 저장된 모든 세션 속성 삭제 *****(로그아웃 기능 구현시 많이 사용)
    session.invalidate();
  %>
  <h4>세션 삭제 후</h4>
  <%
    out.print("getId: " + session.getId());
    if (request.isRequestedSessionIdValid()==true) {
      out.print("<p>세션이 유효합니다.(있다)</p>");
    } else {
      out.print("<p>세션이 유효하지 않습니다.(없다)");
    }
  %>
</body>
</html>
