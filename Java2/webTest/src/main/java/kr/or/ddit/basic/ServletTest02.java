package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 이 예제는 annotation(@WebServlet)을 이용해서 Servlet을 설정하여 처리하는 예제이다.
// annotation(@WebServlet)은 Servlet버전 3.0이상에서 사용할 수 있다.

// @WebServlet annotation의 속성들 
// 1. name 		  :	Servlet의 이름 설정 (기본값: 빈문자열("") )  / 생략 가능 
// 2. urlPatterns : 	Servlet의 URL패턴의 목록을 설정한다. (기본값: 빈 배열({ }) )
//		ex) urlPatterns = "/url1" 또는 urlPatterns = {"/url1"}	==> 패턴이 1개일 때 
//		ex) urlPatterns = {"/url1","/url2", ...}					==> 패턴이 2개 이상일 때
// 3. value		  : urlPatterns속성과 기능이 같다.
// 4. description : 주석(설명글)을 설정한다. 

@WebServlet(urlPatterns = {"/servletTest02.do"},
			description = "annotation을 이용한 Servlet 설정 연습")
public class ServletTest02 extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 처리한 내용을 응답으로 보내기 
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		// 출력용 스트림 객체 구하기 
		PrintWriter out = response.getWriter();
		
		// 내용 출력하기 
		// 방법 2) print() 메서드 또는 println()메서드 이용하기 
		out.println("<html><head><meta charset=utf-8>");
		out.println("<title>두번째 Servlet</title></head>");
		out.println("<body>");
		out.println("<h2 style='text-align:center; color:red;'>");
		out.println("이것은 두번째 Servlet예제입니다. <br>");
		out.println("@WebServlet annotation을 이용한 Servlet입니다.</h2>");
		out.println("</body></html>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
}
