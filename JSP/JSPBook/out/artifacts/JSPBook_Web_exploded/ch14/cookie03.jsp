<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cookie</title>
</head>
<body>
<%
    //   cookie03.jsp를 요청 시 쿠키를 함께 보냄. 그 쿠키는 request 객체에 담김
    Cookie[] cookies = request.getCookies();
    //   cookies[0] : userId
    //   cookies[1] : userPw
    //   cookies[2] : JSESSIONID(영향 없음)
    for(int i = 0; i < cookies.length; i++){
        //   쿠키를 삭제
        cookies[i].setMaxAge(0);
        response.addCookie(cookies[i]);
    }
    response.sendRedirect("cookie02.jsp");
%>
</body>
</html>