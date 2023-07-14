<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<!--
    isErrorPage 속성: 현재 JSP 페이지를 오류 페이지로 호출하는
    page 디렉티브 태그의 속성.
    true 시 exception 내장 객체를 사용할 수 있음
-->
<html>
<head>
    <title>Exception</title>
</head>
<body>
    <h3>오류가 발생했습니다.</h3>
    <!--
        exception: JSP 에서 제공해주는 오류 처리용 기본 내장 객체
        오류 이벤트의 toString()를 호출해서 간단한 오류 메시지 확인
     -->
    <p>예외 유형: <%=exception.toString()%></p>
    <!-- 오류 메시지의 발생 근원지를 찾아 단계별로 오류를 출력 -->
    <%--    <p>단계별 오류 출력: <%=exception.printStackTrace()%></p> --%>
    <!-- 오류 이벤트와 함께 들어오는 메시지를 출력 -->
    <p>오류 메시지: <%=exception.getMessage()%></p>
    <p>예외 객체 타입: <%=exception.getClass().getName()%></p>

</body>
</html>
