package kr.or.ddit.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

public class URLTest02 {
	public static void main(String[] args) throws IOException {
		// URLConnection 클래스 => 애플리케이션과 URL 간의 통신 연결을 위한 클래스 
		
		// 특정 서버의 정보와 파일 내용을 가져와 출력하는 예제 
		
		URL url = new URL("https://www.naver.com/index.html");
		
		// URL 객체를 이용해서 URLConnection 객체를 구한다 
		URLConnection urlCon = url.openConnection();
		
		// Header 정보 구하기 
		// 전체 Header 정보 가져오기 
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();
		
		// 출력하기 
		for (String headerKey : headerMap.keySet()) {
			System.out.println(headerKey + " : " + headerMap.get(headerKey));
		}
		
		System.out.println("=========================================================");
		
		// 연결된 문서의 내용 읽어오기 
		/*
		// 방법 1) URLConnection 객체를 이용하는 방법
		
		// index.html 문서의 내용을 읽어올 스트림 객체 구하기 
		InputStream in = urlCon.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "UTF-8");
		BufferedReader br = new BufferedReader(isr);
		
		//자료를 읽어와 화면에 출력하기
		//읽어온 데이터가 저장될 변수 
		String temp;
		while ((temp=br.readLine())!=null) {
			System.out.println(temp);
		}
		
		//스트림 닫기 
		br.close();
		*/
		
		//방법 2) URL 객체의 openStream() 메서드 이용하기 
		
		InputStream in = url.openStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in, "utf-8"));
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("./src/index.html"));
		
		String str;
		
		while ((str=br.readLine()) != null) {
			//System.out.println(str);
			bw.write(str);
		}
		bw.flush();
		bw.close();
		br.close();
		System.out.println("작업 완료...");
	}
	
}