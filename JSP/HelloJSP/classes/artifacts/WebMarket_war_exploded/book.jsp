<%@page import="vo.BookVO"%>
<%@page import="dao.BookRepository"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
		//싱글톤: 메모리에 객체가1회 생성 . 
		BookRepository bookDAO = BookRepository.getInstance();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<!-- include 액션 태그 -->
<jsp:include page="menu.jsp"/>
<!-- 상품상세시작 -->
<div class="jumbotron">
	<div class="container">
			<h1 class="display-3">도서 정보</h1>
	</div>
</div>
<%//스크립틀릿 
//요청 URI: product.jsp?productId=${product.productId}
//요청 URL: product.jsp
//요청 Parameter:productId=${product.productId}
//요청 방식: get
String bookId = request.getParameter("bookId");
//out.print("productId: " + productId);
//SELECT * FROM PRODUCT WHERE PRODUCT_ID = 'P1234'
BookVO book = bookDAO.getBookById(bookId);
// out.print("<p>"+product + "</p>");
%>
<c:set var="book" value="<%=book%>" />
<!-- 내용 -->
<div class="container">
		<!-- 1건의 상품. 1행(row = record = tuple) -->
		<div class="row">
				<div class="col">
						<h3>${book.name}</h3>
						<p>${book.description}</p>
						<p>
							<b>상품코드:</b>
							<span class="badge badge-danger">
									${book.bookId}
							</span>
						</p>
						<p><b>출판사: </b>${book.publisher}</p>
						<p><b>저자: </b>${book.author}</p>
						<p><b>재고수: </b>${book.unitPrice}</p>
						<p><b>총 페이지 수: </b>${book.unitPrice}</p>
						<p><b>출판일: </b>${book.releaseDate}</p>
						<h3>${ book.unitPrice}원</h3>
						<p>
								<a href="#" class="btn btn-secondary">도서 주문 &raquo</a>
								<a href="books.jsp" class="btn btn-secondary">도서 목록 &raquo</a>
						</p>
				<hr>
				</div>
		</div>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>