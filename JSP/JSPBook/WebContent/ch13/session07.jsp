<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
  <h3>세션 유효 시간 변경</h3>

  <h4>세션 유효 시간 변경 전</h4>
  <%
    //세션에 설정된 유효시간 확인 (기본 1800초 = 30분)
    int time = session.getMaxInactiveInterval();//초 단위
    out.print("세션 유효 시간: " + time + " 초<br/>");
  %>

  <h4>세션 유효 시간 변경 후</h4>
  <%
    //세션에 설정된 유효시간 확인 (기본 1800초 = 30분)
    session.setMaxInactiveInterval(60*60);//1시간
    time = session.getMaxInactiveInterval();
    out.print("세션 유효 시간: " + time + " 초<br/>");
  %>
</body>
</html>
