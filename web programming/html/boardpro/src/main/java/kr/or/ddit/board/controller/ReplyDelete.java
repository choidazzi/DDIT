package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class ReplyDelete
 */
@WebServlet("/ReplyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송시 요청 데이터 받기 - renum
		int renum = Integer.parseInt(request.getParameter("renum"));
		// service	객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		//service메서드 호출 -int 
		int res = service.deleteReply(renum);
		// request에 저장 
		request.setAttribute("result", res);
		// view 이동 
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
		
	}

}
