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
		// URLConnection 클래스 ==> 애플리케이션과 URL간의 통신 연결을 위한 클래스
		
		// 특정 서버의 정보와 파일 내용을 가져와 출력하는 예제
		
		URL url = new URL("https://www.naver.com/index.html");
		
		// URL객체를 이용해서 URLConnection객체를 구한다.
		URLConnection urlCon = url.openConnection();
		
		// Header정보 출력하기
		Map<String, List<String>> headerMap = urlCon.getHeaderFields();  // 전체 Header정보 가져오기
		
		// 출력하기
		for(String headerKey : headerMap.keySet()) {
			System.out.println(headerKey + " : " + headerMap.get(headerKey));
		}
		System.out.println("--------------------------------------------------------");
		
		// 연결된 문서의 내용 읽어오기
		
		
		/*
		// 방법1 ==> URLConnection객체를 이용하는 방법
		
		// index.html문서의 내용을 읽어올 스트림 객체 구하기
		InputStream in = urlCon.getInputStream();
		InputStreamReader isr = new InputStreamReader(in, "utf-8");
		BufferedReader br = new BufferedReader(isr);
		
		// 자료를 읽어와 화면에 출력하기
		String temp;  // 읽어온 데이터가 저장될 변수
		while((temp=br.readLine()) != null) {
			System.out.println(temp);
		}
		
		br.close();  // 스트림 닫기
		*/
		
		
		// 방법2 ==> URL객체의 openStream()메서드 이용하기
		
		InputStream in2 = url.openStream();
		BufferedReader br2 = new BufferedReader(new InputStreamReader(in2, "utf-8"));
		
		BufferedWriter bw = new BufferedWriter(new FileWriter("c:/d_other/index.html"));
		
		String str;
		
		while((str = br2.readLine()) != null) {
			// System.out.println(str);
			bw.write(str + "\n");
		}
		bw.flush();
		
		bw.close();
		br2.close();
		System.out.println("작업 완료...");
		
	}
}
