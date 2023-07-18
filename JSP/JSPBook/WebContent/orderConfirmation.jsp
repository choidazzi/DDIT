<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="vo.ProductVO" %>
<%
  String Shipping_cartId = "";
  String Shipping_name = "";
  String Shipping_shippingDate = "";
  String Shipping_country = "";
  String Shipping_zipCode = "";
  String Shipping_addressName = "";

  Cookie[] cookies = request.getCookies();
  //쿠키 개수만큼 반복
  for (int i = 0; i < cookies.length; i++) {
    Cookie thisCookie = cookies[i];

    //if (thisCookie.getName().equals("Shipping_cartId")) {
    //  Shipping_cartId = URLDecoder.decode(thisCookie.getValue(), "UTF-8");
    //}
    if (thisCookie.getName().equals("Shipping_name")) {
      Shipping_name = URLDecoder.decode(thisCookie.getValue(), "UTF-8");
    }
    if (thisCookie.getName().equals("Shipping_shippingDate")) {
      Shipping_shippingDate = URLDecoder.decode(thisCookie.getValue(), "UTF-8");
    }
    if (thisCookie.getName().equals("Shipping_country")) {
      Shipping_country = URLDecoder.decode(thisCookie.getValue(), "UTF-8");
    }
    if (thisCookie.getName().equals("Shipping_zipCode")) {
      Shipping_zipCode = URLDecoder.decode(thisCookie.getValue(), "UTF-8");
    }
    if (thisCookie.getName().equals("Shipping_addressName")) {
      Shipping_addressName = URLDecoder.decode(thisCookie.getValue(), "UTF-8");
    }
  }
  //세션의 이름인 cartlist를 통해 productVO타입의 상품목록 list를 가져와 보자.
  ArrayList<ProductVO> cartList = (ArrayList<ProductVO>) session.getAttribute("cartlist");
%>
<c:set var="cartList" value="<%=cartList%>"/>
<html>
<head>
    <link rel="stylesheet" href="/css/bootstrap.min.css">
    <title>주문 정보</title>
</head>
<body>
  <jsp:include page="menu.jsp"/>
  <div class="jumbotron">
    <div class="container">
      <h1 class="display-3">주문정보</h1>
    </div>
  </div>
  <div class="container col-8 alert alert-info">
    <div class="text-center">
      <h1>영수증</h1>
    </div>
    <!-- 고객이 작성한 배송 관련 정보(cookie를 활용) -->
    <div class="row justify-content-between">
      <strong>배송주소</strong>
      <p>성명: <%=Shipping_name%></p>
      <p>우편번호: <%=Shipping_zipCode%></p>
      <p>주소: <%=Shipping_addressName%>&nbsp;<%=Shipping_country%></p>
    </div>
    <div class="col-4" align="right">
      <p>
        <em>배송일: <%=Shipping_shippingDate%></em>
      </p>
    </div>
    <!-- 상품 정보 시작 (session 활용) -->
    <div>
      <table class="table table-hover">
        <tr>
          <th class="text-ceter">상품명</th>
          <th class="text-ceter">#</th>
          <th class="text-ceter">가격</th>
          <th class="text-ceter">소계</th>
        </tr>
        <c:forEach var="productVO" items="${cartList}" varStatus="stat">
        <c:set var="total" value="${total + productVO.quantity * productVO.unitPrice}"/>
          <tr>
            <td class="text-center"><em>${productVO.pname}</em></td>
            <td class="text-center">${productVO.quantity}</td>
            <td class="text-center">
              <fmt:formatNumber value="${productVO.unitPrice}" pattern="#,###"/>
            </td>
            <td class="text-center">
              <fmt:formatNumber value="${productVO.quantity * productVO.unitPrice}" pattern="#,###"/>
            </td>
          </tr>
        </c:forEach>
        <tr>
          <td></td>
          <td></td>
          <td class="text-right"><strong>총액:</strong></td>
          <td class="text-center text-danger">
            <strong><fmt:formatNumber value="${total}" pattern="#,###"/></strong>원
          </td>
        </tr>
      </table>
      <a href="shippingInfo.jsp?cartId=<%=Shipping_cartId%>" class="btn btn-secondary" role="button">이전</a>
      <a href="thankCustomer.jsp" class="btn btn-success" role="button">주문 완료</a>
      <a href="checkOutCancelled.jsp" class="btn btn-secondary" role="button">취소</a>
    </div>
  </div>

  <jsp:include page="footer.jsp"/>
</body>
</html>
