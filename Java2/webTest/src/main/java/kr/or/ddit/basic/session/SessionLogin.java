package kr.or.ddit.basic.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.vo.MemberVO;

@WebServlet("/sessionLoginDB.do")
public class SessionLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");
		String pass = request.getParameter("pass");
		
		// 클라이언트로부터 받아온 데이터를 MemberVO 객체에 저장한다.
		MemberVO memVo = new MemberVO();
		memVo.setMem_id(userid);
		memVo.setMem_pass(pass);
		
		// DB에서 해당 ID와 패스워드가 일치하는 회원 정보를 구해온다
		MemberDaoImpl dao = MemberDaoImpl.getInstance();		// Dao객체 
		MemberVO loginMemVo = dao.getLoginMember(memVo);
		
		HttpSession session = request.getSession();
		
		if (loginMemVo != null) {	// 로그인 성공 
			session.setAttribute("loginMember", loginMemVo);
			
		}
				
		response.sendRedirect(request.getContextPath() 
				+ "/basic/session/sessionLoginDB.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
