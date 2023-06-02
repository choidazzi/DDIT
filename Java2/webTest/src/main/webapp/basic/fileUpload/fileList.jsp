<%@page import="kr.or.ddit.vo.FileInfoVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	// 서블릿에서 보낸 자료 받기 
	List<FileInfoVO> fileList = (List<FileInfoVO>)request.getAttribute("fileList");
%>
<body>
<h3>전체 파일 목록</h3>
<a href="<%=request.getContextPath()%>/fileUpload.do">파일업로드하기</a>

<table border="1">
<thead>
	<tr>
		<th>번호</th><th>작성자</th><th>저장파일명</th><th>원래의 파일명</th>
		<th>파일크기</th><th>저장날짜</th><th>비고</th>
	</tr>
</thead>
<tbody>
<%
	if(fileList == null || fileList.size() == 0) {
%>
<tr>
	<td colspan="7">파일목록이 하나도 없습니다.</td>
</tr>
<%
	} else {
		for(FileInfoVO vo : fileList){
%>
	<tr>
		<td><%=vo.getFile_no() %></td>
		<td><%=vo.getFile_writer() %></td>
		<td><%=vo.getSave_file_name() %></td>
		<td><%=vo.getOrigin_file_name() %></td>
		<td><%=vo.getFile_size() %></td>
		<td><%=vo.getFile_date() %></td>
		<td>-</td>
	</tr>
<%
	}
}
%>
</tbody>
</table>
</body>
</html>