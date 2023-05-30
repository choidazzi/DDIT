package kr.or.ddit.basic.cookie;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/cookieCountServlet.do")
public class CookieCountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// Cookie Count를 증가시키는 서블릿 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 쿠키이름 : count로 한다. 
		
		// count라는 쿠키가 있는지 검사한다.
		Cookie[] cookieArr = request.getCookies();
		int cnt = 0;			// 읽어온 count가 저장될 변수 
		for (Cookie cookie : cookieArr) {
			if("count".equals(cookie.getName())) {	// 쿠키이름이 count인지 검사 
				String value = cookie.getValue();	// 쿠키값 (현재의 count	값) 구하기 
				cnt = Integer.parseInt(value);
			}
		}
		
		cnt ++;	// 카운트 증가 
		
		//증가된 카운트값을 갖는 Cookie객체 생성 
		Cookie countCookie = new Cookie("count",String.valueOf(cnt));
		response.addCookie(countCookie); 	// 쿠키 추가 
		out.println("<html><head><meta charset='utf-8'><title>쿠키 연습</title></head>");
		out.println("<body>");
		out.println("<h2>어서오세요. 당신은" + cnt +" 번째 방문입니다.</h2><br><br>");
		
		out.println("<a href='"+request.getContextPath()+
				"/cookieCountServlet.do'> 카운트 증가하기</a>");
		out.println("<a href='"+request.getContextPath()+
				"/basic/cookie/cookieTest02.jsp'> 시작 문서로 이동하기</a>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
