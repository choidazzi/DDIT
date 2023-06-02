<%@page import="kr.or.ddit.member.vo.ZipVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 서블릿에서 저장한 데이터 꺼내기 
List<ZipVO> list = (List<ZipVO>) request.getAttribute("save");
%>
[
	
<%
for(int i=0; i<list.size(); i++) {
	ZipVO vo = list.get(i);
	if(i>0) out.print(","); 
%>

{
	"zipcode" : "<%=vo.getZipcode() %>",
	"sido": "<%=vo.getSido() %>",
	"gugun": "<%=vo.getGugun() %>",
	"dong": "<%=vo.getDong() %>",
	"bungi": "<%=vo.getBunji() %>"
}
<%
};
%>
]