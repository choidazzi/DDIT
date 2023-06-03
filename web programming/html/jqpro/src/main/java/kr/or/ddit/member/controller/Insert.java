package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;


@WebServlet("/Insert.do")
public class Insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Insert() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
/*		
		// 전송시 데이터 얻기 
		String userId = request.getParameter("id");
		String userName = request.getParameter("name");
		String userPass = request.getParameter("pass");
		String userBir = request.getParameter("bir");
		String userHp = request.getParameter("hp");
		String userMail = request.getParameter("mail");
		String userZip = request.getParameter("zip");
		String userAdd1 = request.getParameter("add1");
		String userAdd2 = request.getParameter("add2");
		
		// vo에 저장 
		MemberVO vo = new MemberVO();
		vo.setMem_id(userId);
		vo.setMem_name(userName);
		vo.setMem_pass(userPass);
		vo.setMem_bir(userBir);
		vo.setMem_hp(userHp);
		vo.setMem_mail(userMail);
		vo.setMem_zip(userZip);
		vo.setMem_add1(userAdd1);
		vo.setMem_add2(userAdd2);
		*/
		// 전송시 데이터 받아서 전송시 데이터 받기 
		MemberVO vo = new MemberVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// service객체 얻기 
		IMemberService service = MemberServiceImpl.getInstance();
		// service메소드 호출하기 - 결과값받기 
		int cnt = service.insertMember(vo);
		// 결과값을 request에 저장하기 
		request.setAttribute("save", cnt);
		// view 페이지로 이동
		request.getRequestDispatcher("/0601/insert.jsp").forward(request, response);
	}

}
