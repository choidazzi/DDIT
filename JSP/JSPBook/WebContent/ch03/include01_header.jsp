<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%! // 선언문
	// 전역변수 
  	int pageCount = 0; //방문자수 
	// 전역 메서드, 리턴타입은 없다.
  	void addCount(){
  		//후위증감 연산자 
  		pageCount++;
  	}
%>
<% //스크립틀릿 
//전역메서드 호출 => 방문수1 증가 
addCount();
%>
<p>이사이트의 방문자수는 <%= pageCount %>번 째입니다. </p>