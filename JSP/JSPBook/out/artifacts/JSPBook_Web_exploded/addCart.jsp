<%@ page import="dao.ProductRepository" %>
<%@ page import="vo.ProductVO" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //from: product.jsp
  //to: post방식으로 addCart.jsp?productId=P1234
  String productId = request.getParameter("productId");

  out.print("productId: " + productId);

  //trim: 공백 제거
  if (productId==null || productId.trim().equals("")) {
    response.sendRedirect("products.jsp");
    return;
  }

  ProductRepository dao = ProductRepository.getInstance();
  //select*from product where id = 'P1234'
  ProductVO product = dao.getProductById(productId);
  //상품 결과가 없으면...
  if (product==null) {
    //[상품이 없음] 예외처리 페이지로 이동
    response.sendRedirect("exceptionNoProductId.jsp");
  }

  //상품이 있으면 계속 실행
  //장바구니(session) => 세션명: cartlist
  ArrayList<ProductVO> list
          = (ArrayList<ProductVO>) session.getAttribute("cartlist");
  //장바구니 없으면 생성
  if (list==null) {
    //list는 null이므로 여기서 리스트를 생성해줘야 함
    list = new ArrayList<ProductVO>();
    //cartlist라는 세션명으로 생성
    session.setAttribute("cartlist", list);
  }
  int cnt = 0;
  //장바구니가 있다면 다음을 실행
  //1) 장바구니에 P1234 상품이 이미 있는 경우
  //    private int quantity; 장바구니에 담은 개수
  //    quantity를 1 증가
  for (int i = 0; i < list.size(); i++) {
    //list는 P1234, P1235, P1236
    //list.get(0).getProductId().equals("P1234")
    if (list.get(i).getProductId().equals(productId)) {
      cnt++;//장바구니에 넣을 상품을 찾았다면 1 증가
      //장바구니에 상품이 이미 들어있다면 장바구니에 담은 개수를 1개 증가
      //list.get(i): productVO
      list.get(i).setQuantity(list.get(i).getQuantity() + 1);
    }
  }
  //2) 장바구니에 P1234 상품이 없는 경우
  if (cnt==0) {
    //    quantity를 1로 처리
    product.setQuantity(1);
    //    장바구니에 P1234 상품을 넣어주고
    list.add(product);
  }
  //장바구니 확인
  //ArrayList<productVO> : list
  for (ProductVO vo : list) {
    out.print("vo: " + vo + "<br/><hr/>");
  }
  response.sendRedirect("product.jsp?productId=" + productId);
%>