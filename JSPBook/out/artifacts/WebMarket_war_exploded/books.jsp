<%@page import="dao.BookRepository"%>
<%@page import="vo.BookVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<title>Insert title here</title>
</head>
<body>

<%//스크립틀릿 
	//SELECT * FROM PRODUCT
	BookRepository bookDAO = BookRepository.getInstance();
	List<BookVO> listOfBooks = bookDAO.getAllBooks();
%>
<c:set var="listOfBooks" value="<%=listOfBooks%>" scope="page"/>
<!-- include 액션 태그 -->
<jsp:include page="menu.jsp" />

<!-- body시작 -->
<div class="jumbotron">
	<div class="container">
		<h1 class="display-3">도서목록</h1>
	</div>
</div>
<div class="container">
	<!-- 행 별 처리 -->
	<div class="col" align="left">
		<c:forEach var="book" items="${listOfBooks}" varStatus="stat">
			<div class="row"><!-- 열 별 처리 -->
				<h3>${book.name}</h3>
				<div class="row justify-content-md-center">
					<p class="col" style="text-overflow: ellipsis;
													  overflow: hidden;
													  display: -webkit-box;
													  -webkit-box-orient: vertical;
													  -webkit-line-clamp: 2;">
						  ${book.description}
					</p>
					<p class="col col-lg-2"><a href="book.jsp?bookId=${book.bookId}"
				                  class="btn btn-secondary" role="button">
				            상세정보 &raquo</a></p>   
				</div>
				<div class="row justify-content-md-center" style="font-size: 13px; color: gray">
					<p class="col-md-auto" style="padding: 3px; padding-left: 15px">이름: ${book.author} |</p>
					<p class="col-md-auto" style="padding: 3px">출판사: ${book.publisher} |</p>
					<p class="col-md-auto" style="padding: 3px">가격: ${book.unitPrice}원</p>
				</div>
			</div>
		<hr>
		</c:forEach>
		
	</div>
</div>
<!-- body끝 -->


<!-- footer -->
<jsp:include page="footer.jsp" />
</body>