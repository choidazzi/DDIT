<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.List" %>
<%@ page import="vo.ProductVO" %>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <title>장바구니</title>
</head>
<body>
    <jsp:include page="menu.jsp"/>
    <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">장바구니</h1>
        </div>
    </div>
    <%
        //list
        //addCart.jsp의 cartlist라는 세션 속성명에 list를 매핑
        //session.setAttribute("cartlist", list);
        List<ProductVO> cartlist = (List<ProductVO>) session.getAttribute("cartlist");
        //out.print("cartlist: " + cartlist );

        //세션의 고유 아이디(장바구니 번호)
        String cartId = session.getId();
    %>
    <c:set var="cartList" value="<%=cartlist%>"/>
    <c:set var="cartId" value="<%=cartId%>"/>
    <!-- 장바구니 상세 내역 시작 -->
    <div class="container">
        <div class="row">
            <table style="width: 100%;">
                <tr>
                    <td align="left">
                        <a href="deleteCart.jsp?cartId=${cartId}" class="btn btn-danger">삭제하기</a>
                    </td>
                    <td align="right">
                        <a href="shippingInfo.jsp?cartId=${cartId}" class="btn btn-success">주문하기</a>
                    </td>
                </tr>
            </table>
        </div>
        <div style="padding-top: 50px;">
            <table class="table table-hover">
                <tr>
                    <th>상품</th>
                    <th>가격</th>
                    <th>수량</th>
                    <th>금액</th>
                    <th>비고</th>
                </tr>

                <!-- 장바구니에 상품이 없다면 -->
                <c:if test="${cartList==null}">
                    <tr style="text-align: center;">
                        <td colspan="5">장바구니에 상품이 존재하지 않습니다.</td>
                    </tr>
                </c:if>
                <!-- 장바구니에 상품이 있다면 -->
                <c:if test="${cartList!=null}">
                <!-- List<ProductVO> cartList -->
                    <c:forEach var="productVO" items="${cartList}" varStatus="stat">
                        <c:set var="amount" value="${productVO.unitPrice * productVO.quantity}"/>
                        <c:set var="total" value="${total+amount}"/>
                        <tr>
                            <td>${productVO.productId}-${productVO.pname}</td>
                            <td>${productVO.pname}</td>
                            <td>${productVO.quantity}</td>
                            <td>${amount}</td>
                            <td>
                                <a href="removeCart.jsp?productId=${productVO.productId}"
                                    class="badge badge-danger">삭제</a></td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <th></th>
                        <th></th>
                        <th>총액</th>
                        <th>${total}</th>
                        <th></th>
                    </tr>
                </c:if>
            </table>
            <a href="products.jsp" class="btn btn-secondary">&laquo;쇼핑 계속하기</a>
        </div>
    </div>
    <jsp:include page="footer.jsp"/>
</body>
</html>
