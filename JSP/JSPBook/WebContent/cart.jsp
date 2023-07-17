<%@ page import="java.util.List" %>
<%@ page import="vo.ProductVO" %><%--
  Created by IntelliJ IDEA.
  User: ChoiSeoYeon
  Date: 2023/07/17
  Time: 9:20 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>장바구니</title>
</head>
<body>
    <%
        //list
        //addCart.jsp의 cartlist라는 세션 속성명에 list를 매핑
        //session.setAttribute("cartlist", list);
        List<ProductVO> cartlist = (List<ProductVO>) session.getAttribute("cartlist");
        out.print("cartlist: " + cartlist );
    %>
</body>
</html>
