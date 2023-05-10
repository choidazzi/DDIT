package kr.or.ddit.basic.tcp;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/*
파일을 전송하는 통신 프로그램을 작성하시오.

클라이언트는 서버와 접속이 완료되면 'd:/d_other/'폴더에 있는 '펭귄.jpg'파일을 서버로 전송한다.
(파일을 읽어서 소켓으로 출력하기)

서버는 클라이언트와 접속 완료 후 클라이언트가 보내온 파일을 받아서 'd:/d_other/uploadFiles'폴더에 저장한다.
(소켓으로 읽어서 파일로 출력하기)
*/

public class TcpFileClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		TcpFileClient client = new TcpFileClient();
		
		
		//File file = new File("c:/d_other/펭귄.jpg");
		File file = client.ShowDialog("OPEN");
		
		if(!file.exists()) {
			System.out.println(file.getPath() + "파일이 없습니다...");
			return;
		}
		
		String fileName = file.getName(); // 파일명 구하기
		
		try {
			Socket socket = new Socket("localhost", 7777);
			System.out.println("파일 전송 시작...");
			
			// 처음에는 파일명을 문자열로 전송한다.
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			
			dout.writeUTF(fileName);
			
			
			// 파일 내용을 읽어서 소켓으로 전송한다.
			
			// 파일 읽기용 스트림 객체 생성
			BufferedInputStream bin = new BufferedInputStream(
											new FileInputStream(file));
			
			// 소켓 출력용 스트림 객체 생성
			BufferedOutputStream bout = new BufferedOutputStream(dout);
			byte[] temp = new byte[1024];
			int length = 0;
			
			// 파일 읽어서 소켓 전송하기
			while( (length = bin.read(temp)) > 0) {
				bout.write(temp, 0, length);
			}
			bout.flush();
			
			System.out.println("파일 전송 완료...");
			
			// 스트림과 소켓 닫기
			bout.close();
			bin.close();
			socket.close();
			
		} catch (Exception e) {
			System.out.println("파일 전송 실패!!! --> " + e.getMessage());
		}
		
		
		
		/*
		System.out.println("서버에 연결합니다...");
		System.out.println();
		
		Socket socket = new Socket("localhost", 5555);
		
		System.out.println("서버에 연결되었습니다...");
		System.out.println();
		
		File file = new File("c:/d_other/펭귄.jpg");
		int data;
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		DataOutputStream dout = new DataOutputStream(out);
		data = in.read();
		dout.write(data);
		System.out.println("사진을 보냈습니다...");
		
		dout.close();
		socket.close();
		*/
	}
}
