<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<% 
// 쿠키 정보를 읽어서 처리한다.

String cookieUserId = ""; // 쿠키값이 저장될 변수
String chk = ""; // 체크박스 체크용 변수

Cookie[] cookieArr = request.getCookies();   // 전체 쿠키 정보 가져오기

for(Cookie cookie : cookieArr) {
   if("USERID".equals(cookie.getName())) {   // 원하는 쿠키명 찾기
      cookieUserId = cookie.getValue();   // 쿠키값을 구한다
      chk = cookie.getValue(); 
   }
}


%> 



<body>

<form action="<%=request.getContextPath() %>/cookieLoginServlet.do" method="get">
<table border="1" style="margin: 0 auto;">
<tr>
   <td>ID: </td>
   <td><input type="text" name="userid" value="<%=cookieUserId %>" placeholder="ID 입력하세요."></td>
</tr>   
<tr>
   <td>PASS: </td>
   <td><input type="password" name="pass" placeholder="password 입력하세요"></td>
</tr>   
<tr>
   <td colspan="2"><input type="checkbox"  name="chkid" value="check" <%=chk %> >id 기억하기</td>
</tr>   
<tr>
   <td colspan="2" style="text-align:center;"><input type="submit" value="login"></td>
</tr>   
</table>
</form>

</body>
</html>