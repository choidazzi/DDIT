package kr.or.ddit.basic;

import java.net.MalformedURLException;
import java.net.URL;

public class URLTest01 {
	public static void main(String[] args) throws MalformedURLException {
		// URL 클래스 => 인터넷에 존재하는 서버들의 자원에 접근할 수 있는 주소를 다루는 클래스 
		
		// URL 주소 형식 : 프로토콜://호스트명:포트번호/경로명/파일명?쿼리스트링#참조
		// 				예시 : http://ddit.or.kr:80/index.html?ttt=123 
		
		// 방법 1)
		//URL url = new URL("http://ddit.or.kr:80/index.html?ttt=123 ");
		
		// 방법 2)
		URL url = new URL("http","ddit.or.kr",80,"index.html?ttt=123 ");
		
		System.out.println("Protocol : " + url.getProtocol());
		System.out.println("Host : " + url.getHost());
		System.out.println("Port : " + url.getPort());
		System.out.println("File : " + url.getFile());
		System.out.println("Path : " + url.getPath());
		System.out.println("Query : " + url.getQuery());
		System.out.println();
	}
}
