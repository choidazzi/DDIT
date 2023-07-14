<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  //FORM 인증 형식을 통해 로그인 처리시 session에 로그인 정보가 들어있음
  //session객체: session scope(영역)에서 생성된 JSP내장 객체
  //모든 session을 종료
  //로그인 인증 시 웹 브라우저에 저장된 모든 사용자를 삭제
  session.invalidate();
  //addProduct.jsp를 요청한다는 의미는
  //<role-name>admin</role-name> 롤을 갖고 있어야 함
  //login.jsp에서 로그인 다시 하고 오라는 의미
  response.sendRedirect("addProduct.jsp");
%>
