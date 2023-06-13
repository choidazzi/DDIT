
package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

@WebServlet("/BoardHit.do")
public class BoardHit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardHit() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//요청시 num 받기
		int num = Integer.parseInt(request.getParameter("num"));
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		int res = service.updateHit(num);
		
		request.setAttribute("result", res);
		
		request.getRequestDispatcher("/view/result.jsp").forward(request, response);
		
	}

}
