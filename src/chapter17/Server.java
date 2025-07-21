package chapter17;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * 멀티 채팅을 위한 서버역할
 */
public class Server {

	// 포트 번호 설정
	public static final int PORT = 9000;
	// 클라이언트 리스트
	public static ArrayList<ClientHandler> LIST = new ArrayList<ClientHandler>();	
	
	public static void main(String[] args) {
		try {
			// 서버 설정
			ServerSocket server = new ServerSocket(PORT);
			System.out.println("서버 실행 중 : " + PORT); 
			System.out.println("클라이언트 접속 대기중..."); 
		
			while(true) {
				Socket s = server.accept(); // 클라이언트 접속 대기중
				System.out.println("클라이언트 접속 : " + s);
				
				ClientHandler ch = new ClientHandler(s);
				// 클라이언트 정보 저장
				LIST.add(ch);
				
				// 클라이언트 별로 접속하고 별도 종료 진행
				ch.start();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}// main
}// server

class ClientHandler extends Thread {
	Socket s;
//	OutputStream output;
//	InputStream input;
	
	DataInputStream input;
	DataOutputStream output;
	
	// 생성자
	public ClientHandler(Socket s) {
		try {
			this.s = s;
//			this.output = s.getOutputStream(); // 서버 -> 클라이언트  전송
//			this.input = s.getInputStream(); // 클라이언트 -> 서버    수신
			
			input = new DataInputStream(s.getInputStream());
			output = new DataOutputStream(s.getOutputStream());
			
			String str = "[서버]환영합니다.";
			//output.write(str.getBytes());
			output.writeUTF(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			// 클라이언트 사용 종료 확인 플래그
			boolean flag = true;
			
			while(flag) {
				// client로부터 입력받은 값
				String receiveMsg = input.readUTF();
				
				// client 종료 확인
				if(receiveMsg.equals("exit")) {
					System.out.println("클라이언트 종료");
					flag = false;
					Server.LIST.remove(this);
//					// 저장되있는 클라이언트 정보 삭제
//					for(int i = 0; i < Server.LIST.size(); i++){
//						ClientHandler ch = Server.LIST.get(i);
//						
//						//저장된 포트번호와 클라이언트의 포트번호가 일치할 경우
//						if(ch.s.getPort() == s.getPort()) {
//							// 클라이언트 정보 삭제
//							Server.LIST.remove(i);
//							i = Server.LIST.size();
//						}
//					}
				} else {
					// 서버에 접속중인 모든 클라이언트에게 메세지 전송
					Server.LIST.forEach(ch -> {
						try {
							// 모든 클라이언트에게 메세지 전송
							ch.output.writeUTF(receiveMsg);
						} catch (IOException e) {
							e.printStackTrace();
						}
					});
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
