<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
<%
    //request.getCookies()메서드: 쿠키 정보를 얻어옴
    Cookie[] cookies = request.getCookies();
    out.print("cookies.length: " + cookies.length);
    for (int i = 0; i < cookies.length; i++) {
        out.print("<p>" + cookies[i].getName() + ": "
                + cookies[i].getValue() +"</p>");
    }
    out.print("<p>session.getId(): " + session.getId() + "</p>");
%>
    <!--
        요청 URL: cookie01_process.jsp
        요청 파라미터: {id=master,pass=java}
    -->
    <form action="cookie01_process.jsp">
        <p>ID: <input type="text" name="id"/></p>
        <p>PW: <input type="password" name="pw"/></p>
        <p><input type="submit" value="SUBMIT"></p>
    </form>
</body>
</html>
