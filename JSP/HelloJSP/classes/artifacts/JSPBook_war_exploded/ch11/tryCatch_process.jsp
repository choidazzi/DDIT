<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%--<%@ page errorPage="exception_error.jsp" %>--%>
<!doctype html>
<html lang="en">
<head>
    <title>Exception</title>
</head>
<body>
    <%
        // POST 방식
        // 요청 URL: tryCatch_process.jsp
        // 요청 parameters: {num1=12&num2=6n}
        try {
            String num1 = request.getParameter("num1");
            String num2 = request.getParameter("num2");
            // 문자를 숫자로 형변환
            int a = Integer.parseInt(num1);
            int b = Integer.parseInt(num2); // "6n" <= 문제 발생
            int c = a / b;
            out.print("<p>" + num1 + "/" + num2 + "=" + c + "</p>");
        } catch (NumberFormatException e) {
            /*
            오류 발생 시 tryCatch_error.jsp로 forwarding
            1) forwarding: jsp를 해석 => Compile => html로 리턴 받음. 데이터를 전달 가능
            2) redirect: URL을 재요청. 데이터 전달 어려움
            */
            // request 객체와 response 객체를 전달
            // tryCatch_error.jsp에서도 요청 파라미터인 ?num1=12&num2=6n을 사용할 수 있게 됨
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("tryCatch_error.jsp");
            dispatcher.forward(request, response);
        }
%>
</body>
</html>