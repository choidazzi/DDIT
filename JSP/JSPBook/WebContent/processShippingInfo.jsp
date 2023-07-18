<%@ page import="java.util.Enumeration" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    //요청 파라미터 정보를 쿠키에 넣음
    Enumeration en = request.getParameterNames();
    Cookie[] cookies = new Cookie[6];
    int cnt = 0;
    //파라미터 개수만큼 반복
    while (en.hasMoreElements()) {
        String param = (String) en.nextElement();
        out.print("param: " + param +"<br/>");
        cookies[cnt] = new Cookie("Shipping_"+param, URLEncoder.encode(request.getParameter(param), "UTF-8"));
        cookies[cnt].setMaxAge(24*60*60);
        response.addCookie(cookies[cnt]);
        cnt++;
    }
    out.print("--------------------------------------------");
    response.sendRedirect("orderConfirmation.jsp");
%>
<a href="/ch14/cookie02.jsp">[TEST]쿠키 생성 확인</a>