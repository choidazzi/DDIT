<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // /deleteCart.jsp?cartId="04A..."
    //요청파라미터: cartId="04A..."
    //session.getId(): 세션 고유 아이디 = 고유 장바구니 = 동일 웹브라우저 = 1명의 고객
    String cartId = request.getParameter("cartId");
    //cartId 없으면 cart.jsp로 이동
    if (cartId==null || cartId.trim().equals("")) {
        response.sendRedirect("cart.jsp");
        return;
    }
    //장바구니만 비우자
    session.removeAttribute("cartlist");//장바구니만 삭제
    //만약 session.invalidate() => 모든 세션을 삭제. 로그아웃도 되어버림
    response.sendRedirect("cart.jsp");
%>