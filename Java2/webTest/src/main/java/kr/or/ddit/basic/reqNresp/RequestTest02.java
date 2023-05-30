package kr.or.ddit.basic.reqNresp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/requestTest02.do")
public class RequestTest02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String num1 = request.getParameter("num1");
		String operator = request.getParameter("operator");
		String num2 = request.getParameter("num2");
		
		int number1 = Integer.parseInt(num1);
		int number2 = Integer.parseInt(num2);
		double result = 0;
		
		boolean calcOk = true;	//계산 성공 여부 	
		switch (operator) {
		case "+":
			result = number1 + number2;
			break;
		case "-":
			result = number1 - number2;
			break;
		case "*":
			result = number1 * number2;
			break;
		case "/":
			if(number2 == 0) {
				calcOk =false;
			} else {
				result = Math.round((double) number1 / number2);
			}
			break;
		case "%":
			if(number2 == 0) {
				calcOk =false;
			} else {
				result = number1 % number2;
			}
			break;
		}
		
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<html><head><meta chaset='utf-8'><title>Request연습 Form</title></head>");
		out.println("<body>");
		out.println("<hr>");
		out.println("<h2>계산 결과</h2>");
		out.println("<hr>");
		out.println("<h3>"+ number1 + operator+ number2 + "=");
		if(calcOk) {
			out.println(result);
		} else {
			out.println("계산 불능(0으로 나누기)");
		}
		out.println("</h3></body></html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
