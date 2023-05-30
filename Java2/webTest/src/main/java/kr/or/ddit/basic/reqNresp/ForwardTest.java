package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/forwardTest.do")
public class ForwardTest extends HttpServlet {
   private static final long serialVersionUID = 1L;

   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.setCharacterEncoding("utf-8");
      
      String userName = request.getParameter("username"); // 파라미터 데이터를 받을 수 있다.
      
      String tel = (String)request.getAttribute("tel"); // setAtrribute()메서드로 보낸 데이터 받기

      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=utf-8");
      PrintWriter out = response.getWriter();
      
      out.println("<html><head><meta charset='utf-8'><title>forward연습</title>"
      		+ "<style>\n"
      		+ "table {\n"
      		+ "	border-collapse: collapse;\n"
      		+ "	width: 300px;\n"
      		+ "	height: 100px;\n"
      		+ "}\n"
      		+ "</style></head>");
      
      out.println("<body>");
      
      out.println("<h2>Forward 방식 결과</h2><hr>");
      out.println("<table border='1'>");
      out.println("<tr><td>이 름</td>");
      out.println("<td>" + userName + "</td></tr>");
      
      out.println("<tr><td>전 화</td>");
      out.println("<td>" + tel + "</td></tr>");
      out.println("</table>");
      
      out.println("</body></html>");
      
   }

   
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}