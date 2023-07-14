package filter;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class LogFilter implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Webmarket 초기화...");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("접속한 클라이언트 IP: " + request.getRemoteAddr());
		//시스템 현재 시간(시작 시간)
		long start = System.currentTimeMillis();
		System.out.println("접근한 URL 경로: " + getURLPath(request));
		System.out.println("요청 처리 시작 시각: " + getCurrentTime());
		
		//필터가 연속적으로 있다면 다음 필터로 제어 및 요청/응답 정보를 넘겨줌 
		chain.doFilter(request, response);
		
		//시스템 현재시간(종료시간)
		long end = System.currentTimeMillis();
		System.out.println("요청 처리 종료 시각: " + getCurrentTime());
		System.out.println("요청 처리 소요 시간: " + (end-start) + "ms");
		System.out.println("============================================");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
	private String getURLPath(ServletRequest request) {
        // HttpServletRequest 인터페이스는 ServletRequest 인터페이스를 상속받음
        HttpServletRequest req;
        // currentPath : URL 경로 => /ch12/filter02_process.jsp
        String currentPath = "";
        // queryString : 요청파라미터 => name=개똥이
        String queryString = "";
        // instanceof 연산자 : 객체가 어떤 클래스인지, 어떤 클래스를 상속받았는지 확인할 때 사용
        if(request instanceof HttpServletRequest) {
            // 자식 = (cast)부모
            req = (HttpServletRequest)request;
            currentPath = req.getRequestURI();  //  /ch12/filter02_process.jsp
            System.out.println("currentPath : " + currentPath);
            queryString = req.getQueryString();   //name=개똥이
            // 삼항연산자
            queryString = queryString == null?"":"?"+queryString;
        }
        // /ch12/filter02_process.jsp?name=개똥이
        return currentPath + queryString;
    }

    // 현재 시간을 얻어오는 메소드
    private String getCurrentTime() {
        // 2023/07/13 10:25:12
        DateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        // 캘릭더 객체 생성(싱클톤: 메모리에 1번 생성하고 전역변수처럼 사용)
        Calendar calendar = Calendar.getInstance();
        // 톰켓서버에서 제공해주는 시스템 현재 시간을 구해서 캘린더 객체에 세팅
        calendar.setTimeInMillis(System.currentTimeMillis());
        return formatter.format(calendar.getTime());
    }

}
