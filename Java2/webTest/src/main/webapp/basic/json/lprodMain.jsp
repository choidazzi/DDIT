<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath()%>/js/jquery-3.7.0.min.js"></script>
<style>
table {
	border-collapse: collapse;
}
</style>
</head>
<body>
	<form action="">
		<input type="button" id="lprodBtn" value="Lprod자료 가져오기(Ajax이용)">
		<input type="button" id="lprodBtn2" value="Lprod자료 가져오기(Ajax이용 안 함)">
		<h2>LPROD 자료 목록</h2>
		<div id="result"></div>
	</form>
</body>
<script>
	// ajax 이용 
	$('#lprodBtn').on('click',function(){
		$.ajax({
			url:"<%=request.getContextPath()%>/lprodListServlet.do",
			type: 'post',
			success: function(res) {
					code = "<table border=1>";
					code += "<tr><td>LPROD_ID</td><td>LPROD_GU</td><td>LPROD_NM</td><tr>";
					$.each(res, function(i, v) {
						code += "<tr><td>"+v.lprod_id+"</td><td>"+v.lprod_gu+"</td><td>"+v.lprod_nm+"</td></tr>";
					});
					code += "</table>"
					$("#result").html(code);
			},
			error: function(xhr){
				alert("condition: " + xhr.status)
			},
			dataType: 'json'
		})
	});
	//ajax 이용 안 함 
	$('#lprodBtn2').on('click', function(){
		location.href = "<%=request.getContextPath()%>/lprodListServlet2.do"
	});
</script>
</html>