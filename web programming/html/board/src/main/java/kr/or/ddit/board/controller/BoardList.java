package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.PageVO;


@WebServlet("/boardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 요청시 전송 데이터를 받기 (from ajax) - 페이지 번호, 검색시 stype, sword 
		// page = cPage
		int page = Integer.parseInt(request.getParameter("page"));
		// page는 최초실행시 무조건 1 
		// 즉, stype 과 sword는 최초실행시 무조건 null
		String stype =request.getParameter("stype");
		String sword =request.getParameter("sword");
		
		//2. service 객체를 얻기 
		IBoardService service = BoardService.getInstance();
		// listPerPage(map) 준비작업 
		// 필요항목 : stype(o) sword(o) 
		// start (x) end (x) 
		//-- pageVO 와 getInfo메서드 사용
		PageVO pvo = service.getInfo(page, stype, sword);
		
		// 3, servce메서드 호출 - listPerPage(map) - 결과값 받기 
		Map<String, Object> map = new HashMap<>();
		map.put("start", pvo.getStart());
		map.put("end", pvo.getEnd());
		map.put("stype", stype);
		map.put("sword", sword);
		
		List<BoardVO> boardList = service.listPerPage(map);
		
		request.setAttribute("saveList", boardList);
		request.setAttribute("savePvo", pvo);
		
		request.getRequestDispatcher("/view/list.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
