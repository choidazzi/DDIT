package kr.or.ddit.member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/CheckId.do")
public class CheckId extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CheckId() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청시 전송데이터 받기 - id (ajax 데이터에서 가져옴 / key값)
		String inputId = request.getParameter("id");
		// service 객체 얻기 
		IMemberService service = MemberServiceImpl.getInstance();
		// service 메소드 호출 - 결과값 얻기 - String 
		String res = service.idCheck(inputId);
		// 결과값을 request에 저장 
		request.setAttribute("save", res);
		// view 페이지로 이동 - json 데이터 생성
		request.getRequestDispatcher("/0601/idCheck.jsp").forward(request, response);
	}

}
