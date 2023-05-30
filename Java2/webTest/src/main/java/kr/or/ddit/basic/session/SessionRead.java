package kr.or.ddit.basic.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.SampleVO;
// Session 정보를 읽어오는 서블릿 
@WebServlet("/sessionRead.do")
public class SessionRead extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 저장된 Session 정보 읽어오기 
		// 1. Session 객체를 생성하거나 현재 session가져오기 
		HttpSession session = request.getSession();
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset='utf-8'");
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><meta charset='utf-8'><title>Session 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Session 데이터 확인하기(Read).</h2><br><br>");
		
		// 2. getAttribute()메서드를 이용해서 Session 데이터를 읽어온다.
		// 형식) session객체.geetAttribute("key값");
		//		==> Session에 지정한 'key값'에 해당하는 데이터가 없으면 null을 반환한다.
		String sessionValue = (String) session.getAttribute("testSession");
		
		out.println("testSession의 sessionValue: " + sessionValue + "<br><br>");
		
		String userName = (String) session.getAttribute("userName");
		out.println("userName의 sessionValue: " + userName + "<br><br>");
		int age = 0;
		if(session.getAttribute("age")!=null) {
			age = (int) session.getAttribute("age");
		}
		out.println("age의 sessionValue: " + age + "<br><br>");
		
		
		SampleVO svo = (SampleVO) session.getAttribute("sample"); 
		out.println("sample의 sessionValue: " + svo + "<br><br>");
	
		out.println("<hr>");
		out.println("<h3>Session관련 정보들...</h3>");
		// Session ID		==> session을 구분하기 위한 고유한 값 
		out.println("Session ID: " + session.getId() + "<br>");
		
		// Session 생성 시간	==> 1970년 1월 1일부터 경과한 시간 (밀리 세컨드 단위)
		out.println("Session 생성 시간: " + session.getCreationTime() + "<br>");
		
		// 가장 최근 세션에 접근한 시간 ==> 1970년 1월 1일부터 경과한 시간 (밀리 세컨드 단위)
		out.println("Session 최근 세션 접근 시간 : " + session.getLastAccessedTime() + "<br>");

		// Session 유효시간 ==> (초 단위)
		out.println("Session 유효시간 : " + session.getMaxInactiveInterval() + "<br>");
		
		out.println("<a href='"+request.getContextPath()+
				"/basic/session/sessionTest.jsp'> 시작 문서로 이동하기</a>");
		out.println("</body></html>");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
