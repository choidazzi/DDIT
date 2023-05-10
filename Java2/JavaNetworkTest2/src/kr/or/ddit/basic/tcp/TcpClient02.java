package kr.or.ddit.basic.tcp;

import java.net.Socket;

public class TcpClient02 {

	public static void main(String[] args) {
		// Socket 객체를 생성해서 서버에 연결 요청 신호를 보낸다.
		// 연결이 완료되면 해당 Socket객체를 메시지를 받는 쓰레드와 메시지를 보내는 쓰레드에 주입한다.
		
		try {
			Socket socket = new Socket("localhost", 7777);
			
			Sender sender = new Sender(socket);
			Receiver receiver = new Receiver(socket);
			
			sender.start();
			receiver.start();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
