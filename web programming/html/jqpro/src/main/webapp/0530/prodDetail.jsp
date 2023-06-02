<%@page import="kr.or.ddit.prod.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
ProdVO vo = (ProdVO) request.getAttribute("one");
%>
{ 
	"prod_id": "<%=vo.getProd_id()%>", 
	"prod_name": "<%=vo.getProd_name()%>",
	"prod_lgu": "<%=vo.getProd_lgu()%>", 
	"prod_buyer": "<%=vo.getProd_buyer()%>",
	"prod_cost": "<%=vo.getProd_cost()%>", 
	"prod_price": "<%=vo.getProd_price()%>",
	"prod_sale": "<%=vo.getProd_sale()%>", 
	"prod_outline": "<%=vo.getProd_outline()%>",
	"prod_detail": "<%=vo.getProd_detail()%>" 
}