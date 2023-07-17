<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
  <%
    int a = 10;
    double b = 20.2;
    char c = 'a';

    session.setAttribute("a", a);
    session.setAttribute("b", b);
    session.setAttribute("c", c);

    out.println(session.getAttribute("a"));
    out.println(session.getAttribute("b"));
    out.println(session.getAttribute("c"));

    //session내장 객체 내 어떤 속성값이 있는지?
    String name;//세션 속성명
    String value;
    Enumeration en = session.getAttributeNames();
    while(en.hasMoreElements()){
      name = en.nextElement().toString();
      value = session.getAttribute(name).toString();
      out.print("설정된 세션 속성명: " + name + "<br/>");
      out.print("설정된 세션 속성값: " + value + "<br/>");
    }
  %>
</body>
</html>
