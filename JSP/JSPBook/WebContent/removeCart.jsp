<%@ page import="dao.ProductRepository" %>
<%@ page import="vo.ProductVO" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //http://localhost:8080/removeCart.jsp?productId=P1234
    //요청파라미터를 받아서 변수에 저장
    String productId = request.getParameter("productId");

    //만약에 removeCart.jsp 또는 removeCart.jsp?productId=P0000
    //productId: null
    if (productId==null || productId.trim().equals("")) {
        response.sendRedirect("products.jsp");
        return;
    }
    //상품검색메서드 호출(select*from product where product_id='P1234')
    //상품저장소 클래스=>싱글톤 객체 생성(메모리에 1회 생성. 공유해서 사용)
    ProductRepository dao = ProductRepository.getInstance();
    ProductVO productVO = dao.getProductById(productId);
    if (productVO==null) {//상품검증실패. 해당 상품이 없음
        response.sendRedirect("exceptionNoProductId.jsp");
        return;
    }
    //세션의 장바구니(세션) 목록에서 P1234 상품이 있는지 체크한 후
    //있다면 장바구니에서 제외처리
    //session.setAttribute("cartlist", list);
    List<ProductVO> cartlist = (List<ProductVO>) session.getAttribute("cartlist");
    for (int i = 0; i < cartlist.size(); i++) {
        //파라미터를 받은 변수(productId)-삭제할 대상(P1234)
        if (cartlist.get(i).getProductId().equals(productId)) {
            cartlist.remove(cartlist.get(i));//삭제성공
        }
    }

    response.sendRedirect("cart.jsp");
%>