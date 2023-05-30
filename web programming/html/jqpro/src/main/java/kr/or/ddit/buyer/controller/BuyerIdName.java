package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;


@WebServlet("/BuyerIdName.do")
public class BuyerIdName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BuyerIdName() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 전송시 데이터를 받는다
		

		// db처리 수행 service 객체 얻는다
		IBuyerService service = BuyerServiceImpl.getService();

		// 수행 결과를 얻는다 service 메소드 호출
		List<BuyerVO> list = service.selectIdName();
		
		//request객체로 결과를 저장한다
		request.setAttribute("save", list);
		
		// 수행결과로 응답데이터를 생성 - json 배열 view페이지로 이동하여 결과를 생성
		request.getRequestDispatcher("/0526/idname.jsp").forward(request, response);
	}
	

}
