package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestTest01.do")
public class RequestTest01 extends HttpServlet {
   private static final long serialVersionUID = 1L;

   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // POST방식으로 전달되는 문자 인코딩 방식 설정하기
      request.setCharacterEncoding("utf-8");
      
      // 클라이언트가 보낸 데이터 받기
      
      // 방법1) Request객체의 getParameter()메서드 이용하기
      //  형식) Request객체.getParameter("파라미터명");
      //       ==> 해당 '파라미터명'에 설정된 '값'을 가져온다.
      //       ==> 가져오는 값의 자료형은 'String'이다.
      String userName = request.getParameter("username");      
      String job = request.getParameter("job");
      
      // 방법2) Request객체의 getParameterValues()메서드 이용하기
      //         ==> '파라미터명'이 같은 것이 여러개일 경우에 사용한다.
      
      //  형식) Request객체.getParameterValues("파라미터명") 
      //       ==> 가져오는 값의 자료형은 'String[]'이다.
      String[] hobbies = request.getParameterValues("hobby");
      
      //----------------------------------------------------------
      
      // 클라이언트가 보낸 데이터를 응답으로 보내기
      response.setCharacterEncoding("utf-8");
      response.setContentType("text/html; charset=utf-8");
      
      PrintWriter out = response.getWriter();
      
      out.println("<html><head><meta chaset='utf-8'><title>Request객체 연습</title></head>");
      out.println("<body>");
      
      out.println("<h2>Request 테스트 결과</h2>");
      out.println("<table border='1'>");
      out.println("<tr><td>이 름</td>");
      out.println("<td>" + userName + "</td></tr>");
      
      out.println("<tr><td>직 업</td>");
      out.println("<td>" + job + "</td></tr>");
      
      out.println("<tr><td>취 미</td>");
      out.println("<td>");
      if(hobbies!=null) {
         // 배열 크기만큼 반복해서 값을 출력한다.
         for(int i=0; i<hobbies.length; i++) {
            out.println(hobbies[i] + "<br>");
         }
         /*
         // 향상된 for문
         out.println("<br><br>");
         for(String hobby : hobbies) {
            out.println(hobby + "<br>");
         }
         */
      } else {
         out.println("취미가 없군요!!");
      }
      
      out.println("</td></tr>");
      out.println("</table>");
      out.println("<br><hr><br>");
      out.println("<h2>Request객체의 메서드 결과 출력</h2>");
      out.println("<ul>");
      out.println("<li>클라이언트의 IP주소: "+request.getRemoteAddr()+"</li>");
      out.println("<li>요청 메서드: "+request.getMethod()+"</li>");
      out.println("<li>ContextPath: "+request.getContextPath()+"</li>");
      out.println("<li>Protocol: "+request.getProtocol()+"</li>");
      out.println("<li>URL정보: "+request.getRequestURL()+"</li>");
      out.println("<li>URI정보: "+request.getRequestURI()+"</li>");
      out.println("</ul>");
      
      
      out.println("</body></html>");
      
      
      
   }


   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}