package kr.or.ddit.basic.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UdpClient {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		try {
			// 수신 받은 데이터가 저장될 byte 형 배열 
			byte[] bMsg = new byte[512];
			
			// 소켓 객체 생성 
			DatagramSocket socket = new DatagramSocket();
			
			// 접속할 곳의 주소 정보 생성 
			InetAddress address = InetAddress.getByName("127.0.0.1");
			
			while(true) {
				// 전송할 메시지를 입력받는다.
				System.out.print("보낼 메시지 입력 >> ");
				String msg = scan.nextLine();
				
				// 전송용 패킷 객체 생성 
				DatagramPacket outpacket 
				= new DatagramPacket(msg.getBytes("utf-8"), msg.getBytes("utf-8").length, address, 8888);
				
				// 전송
				socket.send(outpacket);
				
				if ("/end".equals(msg)) {		// 작업 종료 여부 확인...
					break;
				}
				
				//--------------------------------------------------------------------
				// 서버가 보내온 메시지 받아서 화면에 출력하기 
				
				// 수신용 패킷 객체 생성
				DatagramPacket inpacket = new DatagramPacket(bMsg, bMsg.length);
				
				// 데이터 수신 
				socket.receive(inpacket);
				
				System.out.println();
				System.out.println("서버의 응답 메시지 : " + new String(bMsg, 0, inpacket.getLength(),"utf-8"));
			} //while 문 끝...
			System.out.println("송신 완료...");
			System.out.println();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
