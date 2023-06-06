package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.PageVO;


@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		// 1. 요청시 전송 데이터 받기(from ajax) - 페이지 번호, 검색시 stype, sword   
		int page = Integer.parseInt(request.getParameter("page"));
		// page = 최초실행시 무조건 1 
		String stype = request.getParameter("stype");
		String sword = request.getParameter("sword");
		// stype, sword는 최초 실행시 값이 null 
		
		// 2. service객체 얻기 
		IBoardService service = BoardServiceImpl.getInstance();
		//  listPerPage(map)	=호출하기위한 준비 작업
		PageVO pvo = service.getInfo(page,stype,sword);
		// 3. service메서드 호출하기 - 결과값 받기 
		//service.listPerPage( );
		// 4. 결과값 request에 저장
		
		// 5. view 페이지로 이동 
		
	}

}
