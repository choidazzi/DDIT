package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient01 {

	public static void main(String[] args) throws UnknownHostException, IOException {
		/*
		- 현재 자신의 컴퓨터를 나타내는 방법
		1) 원래의 IP주소 : 예) 192.168.142.3  내꺼) 192.168.42.56
		2) 지정된 IP주소 : 127.0.0.1
		3) 원래의 컴퓨터 이름 : 예) DESKTOP-TR9JPHC  내꺼) DESKTOP-5CMUVB6
		4) 지정된 컴퓨터 이름 : localhost
		*/
		
		System.out.println("서버에 연결합니다...");
		System.out.println();
		// 연결할 서버의 정보를 이용하여 Socket객체를 생성한다.
		// 서버의 IP주소와 포트번호를 지정하여 생성한다.
		// Socket객체는 생성이 완료되면 해당 서버로 연결 요청 신호를 보낸다.
		Socket socket = new Socket("192.168.42.56", 7777);
		
		// 이 Socket객체를 생성하는 명령 이후는 서버와 연결이 완료된 후에 처리할 내용을 기술하면 된다.
		
		System.out.println("서버에 연결되었습니다...");
		System.out.println();
		
		// 상대방이 보낸 메시지 받기...
		// 상대방이 보낸 메시지를 받는다는 것은 Socket으로 입력 받는 것을 의미한다.
		// Socket의 InputStream객체를 이용하는 데 이것은 getInputStream()메서드로 구할 수 있다.
		InputStream in = socket.getInputStream();
		
		DataInputStream din = new DataInputStream(in);
		
		// 상대방이 보낸 메시지를 받아서 화면에 출력하기
		System.out.println( "서버에서 보내온 메시지 : " + din.readUTF() );
		System.out.println();
		
		System.out.println("연결을 종료합니다...");
		
		// 소켓과 스트림 닫기
		din.close();
		socket.close();
	}
}
