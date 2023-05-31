<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
// 서블릿에서 저장한 데이터 꺼내기 (casting)
	List<LprodVO> lprodList
				= (List<LprodVO>) request.getAttribute("save");
%>
[
<%
	for(int i=0; i<lprodList.size();i++) {
		LprodVO vo = lprodList.get(i);
		if(i>0) out.print(",");
%>
	{
		"lprod_gu":"<%= vo.getLprod_gu() %>",
		"lprod_nm":"<%= vo.getLprod_nm() %>"
	}
<%
	}
%>
]