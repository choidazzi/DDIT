package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpFileServer {

	public static void main(String[] args) throws IOException {
		File saveDir = new File("c:/d_other/uploadFiles");
		if(!saveDir.exists()) {  // 저장할 폴더가 없으면 폴더를 새로 생성한다.
			saveDir.mkdirs();
		}
		
		try {
			ServerSocket server = new ServerSocket(7777);
			System.out.println("서버가 준비되었습니다...");
			
			Socket socket = server.accept();  // 클라이언트의 연결 요청을 기다린다...
			
			System.out.println("파일 다운로드 시작...");
			
			// 클라이언트가 첫번째로 보낸 '파일명' 데이터를 받는다.
			DataInputStream din = new DataInputStream(socket.getInputStream());
			
			String fileName = din.readUTF();
			
			// 저장할 폴더와 클라이언트가 보내온 파일명을 지정하여 File객체를 생성한다.
			File saveFile = new File(saveDir, fileName);
			
			
			// 소켓으로 읽어서 파일로 저장하기
			
			// 데이터를 입출력 할 스트림 객체 생성
			BufferedInputStream bin = new BufferedInputStream(din);
			BufferedOutputStream bout = new BufferedOutputStream(
											new FileOutputStream(saveFile));
			
			// 소켓으로 읽어온 데이터를 파일로 저장하기
			byte[] temp = new byte[1024];
			int length = 0;
			
			while( (length=bin.read(temp))>0 ) {
				bout.write(temp, 0, length);
			}
			bout.flush();
			
			System.out.println("파일 다운로드 완료...");
			
			// 스트림과 소켓 닫기
			bin.close();
			bout.close();
			socket.close();
			server.close();
			
			
		} catch (Exception e) {
			System.out.println("파일 다운로드 실패!!! ==> " + e.getMessage());
		}
		
		/*
		ServerSocket server = new ServerSocket(5555);
		
		System.out.println("접속을 기다립니다...");
		
		Socket socket = server.accept();
		
		System.out.println("클라이언트와 연결되었습니다...");
		
		System.out.println();
		
		File file = new File("c:/d_other/펭귄.jpg");
		FileInputStream fin = new FileInputStream(file);
		BufferedInputStream bin = new BufferedInputStream(fin);
		
		// 대상 파일에 저장할 스트림 객체 생성
		FileOutputStream fout = new FileOutputStream("c:/d_other/uploadFiles/펭귄.jpg");
		BufferedOutputStream bout = new BufferedOutputStream(fout);
		int data;
		data = bin.read();
		
		server.close();
		socket.close();
		bin.close();
		bout.close();
		*/
	}

}
