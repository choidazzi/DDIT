<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@page import="vo.UsersVO"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
    요청 URL: validation05_process.jsp
    요청 Parameter: {
                    id=a001,
                    pass=1234,
                    name=최서연,
                    phone1=010,
                    phone2=1234,
                    phone3=1234,
                    email=test@test.co.kr
                    }
    요청 방식: post
--%>
<%
request.setCharacterEncoding("UTF-8");
String id = request.getParameter("id");
String pass = request.getParameter("pass");
String name = request.getParameter("name");
String phone = request.getParameter("phone");
String phone1 = request.getParameter("phone1");
String phone2 = request.getParameter("phone2");
String phone3 = request.getParameter("phone3");
String email = request.getParameter("email");

UsersVO usersVO = new UsersVO();
usersVO.setId(id);
usersVO.setPass(pass);
usersVO.setName(name);
usersVO.setPhones(phone1, phone2, phone3);
usersVO.setEmail(email);

out.print("usersVO: " + usersVO);
%>
<c:set value="<%=usersVO %>" var="usersVO" />
<p>아이디: ${usersVO.id}</p>
<p>비밀번호: ${usersVO.pass}</p>
<p>이름: ${usersVO.name}</p>
<p>연락처: ${usersVO.phone}</p>
<p>이메일: ${usersVO.email}</p>





