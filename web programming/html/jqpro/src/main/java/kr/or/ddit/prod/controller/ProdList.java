package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

@WebServlet("/prodList.do")
public class ProdList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 전송 요청 시 전달 데이터 받기: gu
		String lgu = request.getParameter("gu");
		// service 객체 얻기
		IProdService service = ProdServiceImpl.getInstance();
		// service 메서드 호출하기 -> 결과값 가져오기
		List<ProdVO> selectIdName = service.ProdByLgu(lgu);
		// 결과값을 request에 저장하기
		request.setAttribute("lgu", selectIdName);
		// view(jsp)로 이동하기 /0530/prodList.jsp
		request.getRequestDispatcher("/0530/prodList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}