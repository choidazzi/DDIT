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

// Session 정보를 저자하는 서블릿 
@WebServlet("/sessionAdd.do")
public class SessionAdd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session 정보를 저장하는 방법
		
		// 1. Session객체를 생성하거나 현재의 Session 가져오기 
		// 형식 1) request객체.getSession(); 또는 request객체.getSession(true);
		// 	==> 현재 session이 존재하면 현재 session을 반환하고, 존재하지 않으면 새로운 session을 생성한다. 
		
		// 형식 2) request객체.getSession(false);
		// 	==> 현재 session이 존재하면 현재 session을 반환하고, 존재하지 않으면 새로운 session을 생성하지 않고 null을 반환한다. 
		HttpSession session = request.getSession();
		
		// 2. setAttribute()메서드를 이용해서 Session값을 저장한다.
		// 형식) session객체.geetAttribute("key값",데이터);
		//		==> 'key값'은 문자열, '데이터'는 java의 모든 데이터 
		session.setAttribute("testSession", "연습용 session 데이터 입니다.");
		session.setAttribute("userName", "신짱구");
		session.setAttribute("age", 5);
		
		SampleVO svo = new SampleVO();
		svo.setName("봉미선");
		svo.setNum(28);
		session.setAttribute("sample", svo);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset='utf-8'");
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta charset='utf-8'><title>Session 연습</title></head>");
		out.println("<body>");
		out.println("<h2>Session 데이터를 저장했습니다.</h2><br><br>");
		out.println("<a href='"+request.getContextPath()+
					"/basic/session/sessionTest.jsp'> 시작 문서로 이동하기</a>");
		out.println("</body></html>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
