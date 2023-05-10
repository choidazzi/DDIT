package kr.or.ddit.basic.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TcpMultiChatServer {
	// 접속한 클라이언트 정보를 저장할 Map 객체 선언
	// ==> key 값: 접속한 사람의 '대화명', value 값: 접속한 클라이언트의 Socket 객체
	private Map<String, Socket> clientMap;

	// 생성자
	public TcpMultiChatServer() {
		// clientMap 을 동기화 처리가 되도록 생성한다.
		clientMap = Collections.synchronizedMap(new HashMap<>());
	}

	public static void main(String[] args) {
		new TcpMultiChatServer().serverStart();
	}

	// 서버의 시작 메서드
	public void serverStart() {
		ServerSocket server = null;
		Socket socket = null;

		try {
			server = new ServerSocket(7777);
			System.out.println("서버가 시작되었습니다...");

			while (true) {
				socket = server.accept(); // 클라이언트의 접속을 기다린다...
				System.out.println("[" + socket.getInetAddress() + ":" + socket.getPort() + "]에서 접속했습니다.");
				System.out.println();
				// ------------------------------------------------------

				ServerReceiver serverThread = new ServerReceiver(socket);
				serverThread.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	} // 시작메서드 끝...

	// clientMap 에 저장된 전체 사용자에게 메시지를 전송하는 메서드
	private void sendToAll(String msg) {
		// clientMap 의 데이터 개수만큼 반복
		for (String name : clientMap.keySet()) {
			try {
				// key 값과 같이 저장된 Socket객체를 이용하여 출력용 스트림 객체를 생성한다.
				DataOutputStream dout = new DataOutputStream(clientMap.get(name).getOutputStream());
				dout.writeUTF(msg);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}// sendToAll() 메서드 끝 ...
		// ------------------------------------------------------
		// 서버에서 클라이언트로 메시지를 전송하는 Thread 를 Inner Class 로 작성한다.
		// => Inner Class 로 작성하는 이유 : Outer Class 의 멤버들을 자유롭게 사용하기 위해서 ...

	class ServerReceiver extends Thread {
		private Socket socket;
		private DataInputStream din;
		private DataOutputStream dout;

		// 생성자
		public ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				din = new DataInputStream(this.socket.getInputStream());

				// 송신용 스트림 객체 생성
				dout = new DataOutputStream(this.socket.getOutputStream());

			} catch (Exception e) {
				// TODO: handle exception
			}
		} // 생성자 끝

		@Override
		public void run() {
			String name = ""; // 대화명이 저장될 변수 선언
			try {
				// 클라이언트가 연결이 성공하면 첫 번째 데이터로 '대화명'을 입력 받아서 서버로 보낸다.
				// 서버에서는 이 '대화명'을 받아서 중복여부를 판정하여 그 결과를 응답 (feedback) 으로
				// 클라이언트에게 보내준다.

				// 클라이언트가 보내온 '대화명'이 중복되지 않을 때 까지 반복한다.
				while (true) {
					// 클라이언트가 보낸 '대화명' 받기
					name = din.readUTF();

					if (clientMap.containsKey(name)) { // '대화명'이 중복되면...
						dout.writeUTF("대화명 중복"); // '대화명 중복' 이라는 메시지를 클라이언트로 보낸다.
					} else { // '대화명'이 중복되지 않을 때...
						dout.writeUTF("OK"); // 'OK' 라는 메시지 전송
						break; // 반복문 탈출...
					}
				} // while문 끝...
					// 접속한 사람의 대화명을 이용하여 이미 접속해 있는 다른 클라이언트들에게 대화방 참여 메시지를 보낸다.
				sendToAll("[" + name + "] 님이 대화방에 입장했습니다.");
				// '대화명' 과 접속한 클라이언트의 Socket 객체를 cilentMap 에 추가한다.
				clientMap.put(name, socket);

				System.out.println("현재 접속자 수: " + clientMap.size() + "명");

				// 한 클라이언트가 보낸 메시지를 받아서 전체 클라이언트에게 보낸다.
				while (din != null) {
					sendToAll(din.readUTF());
				}
			} catch (Exception e) {
				// TODO: handle exception
			} finally {
				// 이 finally영역이 실행된다는 것은 한 클라이언트가 접속을 종료했다는 의미이다.

				sendToAll("[" + name + "]님이 접속을 종료했습니다...");

				System.out.println("[" + socket.getInetAddress() + " : " + socket.getPort() + "]에서 접속을 종료했습니다...");

				// 접속을 종료한 클라이언트를 clientMap에서 삭제한다.
				clientMap.remove(name);

				System.out.println("현재 접속자 수 : " + clientMap.size() + "명");
				System.out.println();
			}
		}
	}
}
