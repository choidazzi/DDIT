<%@page import="kr.or.ddit.member.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@page import="kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
	border: 2px solid #000;
	border-collapse: collapse;
}

td {
	width: 200px;
	height: 50px;
	text-align: center;
}
tr:first-child {
	background-color: lightyellow;
}
</style>
</head>
<body>
<%
	// 전송 데이터 받기 
	
	// DB처리 - 결과값을 받는다
	// SqlSession이 필요 - SqlSessionFactory에 의해서 생성 
	// 1. SqlSessionFactory - mybatis-config.xml이 필요 
	// (DB설정, vo alias설정, mapperm설정이 필요) 
	// 2. SqlSession
	// 3. SqlSession 객체로 mapper의 SQL문장들을 수행 
	SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
	List<MemberVO> memberList = sqlSession.selectList("member.getAllMember");
	
	
	// 결과값을 출력하기 
%>
<table border="1">
	<tr>
		<td>아이디</td>
		<td>이름</td>
		<td>전화번호</td>
		<td>주소</td>
	</tr>
[
<%	//JAVA
	for(int i=0; i<memberList.size(); i++) {
		MemberVO vo = memberList.get(i);
%>
	<tr>
		<td><%=vo.getMem_id() %></td>
		<td><%=vo.getMem_name() %></td>
		<td><%=vo.getMem_tel() %></td>
		<td><%=vo.getMem_addr() %></td>
	</tr>

<% //JAVA
	}
%>	
]
</table>	

</body>
</html>