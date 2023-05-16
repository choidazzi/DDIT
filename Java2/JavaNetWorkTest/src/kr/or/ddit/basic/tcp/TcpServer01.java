package kr.or.ddit.basic.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer01 {

	public static void main(String[] args) throws IOException {
		// TCP소켓 통신을 하기 위해 ServerSocket객체를 생성한다.
		ServerSocket server = new ServerSocket(7777);
		
		System.out.println("접속을 기다립니다...");
		
		// accept()메서드
		//  ==> 클라이언트는 연결 요청이 올 때까지 기다린다.
		//  ==> 연결 요청이 오면 새로운 Socket객체를 생성해서 클라이언트의 Socket과 연결한다.
		Socket socket = server.accept();
		
		// 이 accept()메서드 이후의 내용은 클라이언트와 연결이 완료되어야만 실행된다.
		System.out.println("클라이언트와 연결되었습니다...");
		
		System.out.println();
		
		System.out.println("접속한 상대방의 정보...");
		System.out.println("IP주소 : " + socket.getInetAddress().getHostAddress());
		System.out.println("포트번호 : " + socket.getPort());
		System.out.println();
		
		System.out.println("내 컴퓨터의 정보...");
		System.out.println("IP주소 : " + socket.getLocalAddress().getHostAddress());
		System.out.println("포트번호 : " + socket.getLocalPort());
		System.out.println();
		
		// 클라이언트에게 메시지 보내기 ==> Socket의 OutputStream객체를 이용하여 전송한다.
		//								==> Socket객체의 getOutputStream() 메서드를 이용해서 구할 수 있다.
		OutputStream out = socket.getOutputStream();
		
		// 문제 데이터를 보낼 때 사용할 수 있는 보조 스트림들...
		// OutputStreamWriter, DataOutputStream
		DataOutputStream dout = new DataOutputStream(out);
		
		// 메시지 보내기...
		// 상대방에게 메시지를 보낸다는 것은 Socket으로 출력하는 것과 같다.
		dout.writeUTF("환영합니다. 어서오세요...");
		
		System.out.println("메시지를 보냈습니다...");
		
		// 소켓과 스트림 닫기
		dout.close();
		
		socket.close();
		server.close();
	}
}
