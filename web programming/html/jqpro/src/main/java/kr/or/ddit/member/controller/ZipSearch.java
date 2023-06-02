package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;


@WebServlet("/ZipSearch.do")
public class ZipSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ZipSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 요청시 전송데이터 받기 - dong
		String searchDong = request.getParameter("dong");
		// service 객체 얻기 
		IMemberService service = MemberServiceImpl.getInstance();
		// service 메소드 호출 - 결과값 얻기 - List
		List<ZipVO> list = service.searchZip(searchDong);
		// 결과값을 request에 저장 
		request.setAttribute("save", list);
		// view 페이지로 이동 - json 데이터 생성
		request.getRequestDispatcher("/0601/zipSearch.jsp").forward(request, response);
	}

}
