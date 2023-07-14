package filter;

import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;

public class InitParamFilter implements Filter {
    /*
        <init-param>
            <param-name>param1</param-name>
            <param-value>admin</param-value>
        </init-param>
        <init-param>
            <param-name>param2</param-name>
            <param-value>1234</param-value>
        </init-param>
        값들이 FilterConfig filterConfig에 들어온다
     */
    private FilterConfig filterConfig = null;
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter02 초기화...");
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter02 수행...");
        //사용자가 입력한 요청 파라미터
        //filter01_process.jsp?id=admin&pass=1234
        String id = request.getParameter("id");
        String pass = request.getParameter("pass");

        //web.xml에서 넘어온 초기화 파라미터
        String param1 = this.filterConfig.getInitParameter("param1");//admin
        String param2 = this.filterConfig.getInitParameter("param2");//1234

        String message;

        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        if (id.equals(param1)&&pass.equals(param2)) {
            message = "Login Success!";
        } else {
            message = "Login Failed!";
        }
        //response객체에 message를 추가해줌
        writer.println(message);
        //다음 필터로 제어를 넘김
        chain.doFilter(request, response);
    }

    public void destroy() {
    }
}
