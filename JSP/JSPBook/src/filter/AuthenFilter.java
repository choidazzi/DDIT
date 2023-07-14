package filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class AuthenFilter implements Filter {
    //filter 시작, 초기화
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        System.out.println("Filter01 초기화 완료");
    }

    //filter 기능 수행
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        // /ch12/filter01_process.jsp?name=최서연
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");//최서연
        //응답 메시지를 담아서 서버에서 클라이언트로 전달해줌(response객체)
        if (name==null || name.equals("")) {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("text/html; charset=UTF-8");//MIME 타입
            PrintWriter writer = response.getWriter();
            String message = "입력된 name값은 null입니다.";
            writer.println(message);
            return;
        }
        //filter 가 여러개 있을 때 전달 ~ 전달 해 줌
        filterChain.doFilter(request, response);
    }
    //filter 종료
    @Override
    public void destroy() {
    }
}
