<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
  <h3>세션 이름을 열거해보자.</h3>
  <h4>세션 삭제 전</h4>
  <%
    //세션의 모든 세션명을 열거형으로 가져와보자.
    Enumeration en = session.getAttributeNames();
    String name;
    String value;
    //세션명이 없을 때까지 반복
    while (en.hasMoreElements()) {
      //name: 세션명 - userId, userPw
      name = en.nextElement().toString();
      //value: 세션명에 매핑된 값 - admin. java
      value = session.getAttribute(name).toString();

      out.print("설정된 세션명: " + name + "<br/>");
      out.print("설정된 세션명에 매핑된 값: " + value + "<br/>");
    }

    session.removeAttribute("userId");
  %>
  <h4>세션 삭제 후</h4>
  <%
    en = session.getAttributeNames();
    while (en.hasMoreElements()) {
      name = en.nextElement().toString();
      value = session.getAttribute(name).toString();

      out.print("설정된 세션명: " + name + "<br/>");
      out.print("설정된 세션명에 매핑된 값: " + value + "<br/>");
    }
  %>
</body>
</html>
