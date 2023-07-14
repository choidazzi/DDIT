<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.util.Date"%>
<%@ page isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    // out.print(greeting);
    // out.print(test);	// 문제발생!
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>상품 페이지 오류</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
</head>
<body>
<!--//////////////////////////header 시작(menu.jsp)///////////////////////  -->
<%@ include file="menu.jsp" %>
<!--//////////////////////////header 끝///////////////////////  -->
    <div class="jumbotron">
        <div class="container" style="text-align: center;">
            <h1 class="alert alert-danger">요청하신 페이지를 찾을 수 없습니다.</h1>
        </div>
    </div>
    <div class="container">
        <!--
            .getRequestURI(): http://localhost/product.jsp
            .getQueryString(): productId=P0000
        -->
        <p><%=request.getRequestURI()%></p>
        <p><a href="products.jsp" class="btn btn-secondary">상품 목록&raquo;</a></p>
    </div>
<!-- footer시작 -->
<%@ include file="footer.jsp" %>
<!-- footer끝 -->
<%
    String test = "개똥이";
%>
<%-- 	<h1><%= greeting %></h1>
	<h3><%= tagline %></h3> --%>

</body>
</html>