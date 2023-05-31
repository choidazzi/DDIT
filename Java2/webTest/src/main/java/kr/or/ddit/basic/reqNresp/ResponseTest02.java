package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/responseTest02.do")
public class ResponseTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * -redirect 방식 
		 * 	다른 페이지로 이동한다.
		 *	(HttpServletRequest객체와 HttpServletResponse객체를 공유하지 않는다.)
		 *	응답시 브라우저에게 '이동할 URL'을 전송하여 브라우저가 해당 URL로 이동하는 방식이다.
		 *	이동할 때의 전송방식은 GET방식으로 요청하여 이동한다.
		 *	(URL의 길이에 제한이 있다.)
		 */
		/*
		 * redirect는 Request객체를 공유하지 못한다 (브라우저에서 새롭게 요청하기 떄문에...)
		request.setAttribute("tel", "010-1234-5678");	// 보낼 데이터 셋팅 
		
		// redirect로 이동은 response 객체의 sendRedirect() 메서드를 사용한다.
		// 이 때 이동할 URL주소는 전체 URL경로를 지정해 주어야 한다.
		response.sendRedirect(request.getContextPath() + "/redirectTest.do");
		*/
		// 데이터를 Redirect방식으로 보내려면 GET방식으로 보낼 수 있다. 
		request.setCharacterEncoding("utf-8");
		String userName = request.getParameter("username");
		String tel  = "010-9999-8888";
		// URL경로에 한글이 포함될 경우 : URLEncoder객체를 이용하여 인코딩해서 지정해주어야 한다.
		userName = URLEncoder.encode(userName,"utf-8");
		response.sendRedirect(request.getContextPath() 
				+ "/redirectTest.do?username=" + userName + "&tel=" + tel);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
