<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //요청 URL: cookie01_process.jsp
    //요청 파라미터: {id=master,pass=java}
    String id = request.getParameter("id");
    String pw = request.getParameter("pw");

    if (id.equals("admin") && pw.equals("java")) {
        //Cookie객체 생성
        //"userId" : 쿠키 name, id(admin): 쿠키 value
        Cookie cookieId = new Cookie("userId", id);
        Cookie cookiePw = new Cookie("userPw", pw);
        //response 내장 객체를 통해 쿠키를 리턴받음
        response.addCookie(cookieId);
        response.addCookie(cookiePw);
        out.print("<p>" + id + "님 환영합니다! ^0^</p>");
    } else {
        out.print("<p> 쿠키 생성 실패!</p>");
    }
%>

<p><a href="cookie01.jsp">cookie01.jsp로 이동</a></p>