<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session</title>
</head>
<body>
<%
    //한글 인코딩 처리
    request.setCharacterEncoding("UTF-8");
    String id = request.getParameter("id");
    String pw = request.getParameter("pass");

    out.print("session고유아이디(웹 브라우저별 1개): " + session.getId() + "<br/>");
    if (id.equals("admin")&&pw.equals("java")) {
        session.setAttribute("userId", id);
        session.setAttribute("userPw",pw);
        out.print("<p>세션 설정 성공 ^0^</p>");
        out.print("<p>" + id + "님 환영합니다.</p>");
    } else {
        out.print("<p>세션 설정 실패 ㅠㅡㅠ</p>");
        out.print("<a href='session01.jsp>되돌가가기</a>");

    }
%>
</body>
</html>
