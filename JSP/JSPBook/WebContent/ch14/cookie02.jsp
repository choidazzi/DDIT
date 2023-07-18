<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
<%
  //요청시 함께 던지는 request객체 안에 있는 쿠키들을 확인해보자
  //Cookie cookieId = new Cookie("userId", id);
  //Cookie cookiePw = new Cookie("userPw", pw);
  //+JSESSIONID
  Cookie[] cookies = request.getCookies();

  //현재 쿠키저장소에 들어있는 쿠키의 개수는?
  out.print("현재 설정된 쿠키의 개수: " + cookies.length + "<br/>");
  out.print("<hr/>");
  for (int i = 0; i < cookies.length; i++) {
    out.print("쿠키[" + i + "]:" + cookies[i] + "<br/>");
    out.print("쿠키 속성명[" + i + "]:" + cookies[i].getName() + "<br/>");
    out.print("쿠키 속성값[" + i + "]:" + cookies[i].getValue() + "<br/>");
    out.print("================================<br/>");
  }
  out.print("세션 ID: " + session.getId());
%>
  <a href="cookie03.jsp">모든 쿠키 다 삭제</a>
</body>
</html>
