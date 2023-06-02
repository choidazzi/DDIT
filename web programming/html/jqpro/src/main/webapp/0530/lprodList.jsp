<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// 서블릿에서 저장한 데이터 꺼내기
List<LprodVO> list = (List<LprodVO>) request.getAttribute("allList");
%>
[
<%
for (int i = 0; i < list.size(); i++) {
	LprodVO vo = list.get(i);
	if (i > 0) {
		out.print(", ");
	}
%>
	{
		"gu": "<%=vo.getLprod_gu() %>",
		"nm": "<%=vo.getLprod_nm() %>"
	}
<%
	}
%>
]