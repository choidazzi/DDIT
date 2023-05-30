<%@page import="kr.or.ddit.lprod.vo.LprodVO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.mybatis.config.MyBatisSqlSessionFactory"%>
<%@page import="org.apache.ibatis.session.SqlSession"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlSession();
	
	List<LprodVO> list = sqlSession.selectList("lprod.getAllProd"); 
%>

[
<%
	//for(int i=0; i<list.size();i++){
	//	LprodVO vo = list.get(i);
	int i = 0;
	for(LprodVO vo:list){
		if(i > 0) out.print(",");
%>
	{
		"id" : "<%=vo.getLprod_id() %>",
		"gu" : "<%=vo.getLprod_gu() %>",
		"nm" : "<%=vo.getLprod_nm() %>"
	}
<%		
	i++;
	}
%>
]