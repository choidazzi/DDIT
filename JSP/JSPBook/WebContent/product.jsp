<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@page import="vo.ProductVO"%>
<%@page import="dao.ProductRepository"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page errorPage="exceptionNoProductId.jsp" %>
<%
	//싱글톤: 메모리에 객체가1회 생성 .
	ProductRepository productDAO = ProductRepository.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="/css/bootstrap.min.css">
	<title>Insert title here</title>
</head>
<body>
<!-- include 액션 태그 -->
<jsp:include page="menu.jsp"/>
<!-- 상품상세시작 -->
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">상품 정보</h1>
	</div>
</div>
<%//스크립틀릿
//요청 URI: product.jsp?productId=${product.productId}
//요청 URL: product.jsp
//요청 Parameter:productId=${product.productId}
//요청 방식: get
	String productId = request.getParameter("productId");
//out.print("productId: " + productId);
//SELECT * FROM PRODUCT WHERE PRODUCT_ID = 'P1234'
	ProductVO product = productDAO.getProductById(productId);
// out.print("<p>"+product + "</p>");
%>
<c:set var="product" value="<%=product%>" />
<!-- 내용 -->
<div class="container">
	<!-- 1건의 상품. 1행(row = record = tuple) -->
	<div class="row">
		<!-- 상품 이미지 -->
		<div class="col-md-5">
			<img src="/images/<%=product.getFilename()%>"
				 alt="${product.pname }"
				 title="${product.pname}"
				 style="width: 100%">
		</div>
		<!-- 6크기의 1열(컬럼= -->
		<div class="col">
			<h3 style="display: inline; margin-right: 8px;">${product.pname}</h3>
			<a href="logout.jsp" class="btn btn-sm btn-success pull-right">logout</a>
			<p>${product.description}</p>
			<p>
				<b>상품코드:</b>
				<span class="badge badge-danger">
					${product.productId}
				</span>
			</p>
			<p><b>제조사: </b>${product.manufacturer}</p>
			<p><b>분류: </b>${product.category}</p>
			<p><b>재고 수: </b>${product.unitsInStock}</p>
			<p>
			<form name="addForm" action="addCart.jsp?productId=${product.productId}" method="post">
				<!-- addToCart() 핸들러 함수 -->
				<a href="#" class="btn btn-info" onclick="addToCart()"> 상품 주문 &raquo;</a>
				<a href="cart.jsp" class="btn btn-warning">장바구니&raquo;</a>
				<a href="products.jsp" class="btn btn-secondary">상품 목록 &raquo</a>
			</form>
			</p>
		</div>
	</div>
</div>
<jsp:include page="footer.jsp"/>
<script>
	function addToCart() {
		if(confirm("상품을 장바구니에 추가하시겠습니까?")){//'확인' 클릭시(true)
			//요청 URI: addCart.jsp?productId=P1234
			//<form name="addFrom"...
			document.addForm.submit();
		} else {//'취소' 클릭시(false)
			alert("취소되었습니다.");
		}
	}
</script>
</body>
</html>
