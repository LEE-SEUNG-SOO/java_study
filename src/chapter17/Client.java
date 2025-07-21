package chapter17;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 멀티 채팅을 위한 클라이언트
 */
public class Client {

	public static void main(String[] args) {
		try {
			String id = "[이순신]";
			final String HOST = "localhost";
			final int PORT = 9000;			
			Frame f = new Frame("채팅 클라이언트");
			Panel p = new Panel();
			f.setLayout(new BorderLayout());
			TextArea ta = new TextArea();
			TextField tf = new TextField(40);
			Button button1 = new Button("종료");
			Button send = new Button("전송");
			ta.setEditable(false);
			tf.setText(id);
			p.add(tf);
			p.add(send);
			
			Socket s = new Socket(HOST,PORT); //localhost, 127.0.0.1, 본인 IP
			System.out.println(id +"접속" );
			
//			InputStream input = s.getInputStream();
//			OutputStream output = s.getOutputStream();
			
//			byte[] buffer = new byte[1024];
//			int bytesRead = input.read(buffer);

//			if(bytesRead != -1) {
//				String receivedMessage = new String(buffer, 0, bytesRead, "UTF-8");			
//				System.out.println("서버로부터 받은 메세지 : " + receivedMessage);
//				ta.append(receivedMessage);
//			}
			
			DataInputStream input = new DataInputStream(s.getInputStream());
			DataOutputStream output = new DataOutputStream(s.getOutputStream());

			// 입력만 받는 쓰레드
			new ServiceThread(input,ta).start();
			
			f.add(p, BorderLayout.NORTH);
			f.add(ta, BorderLayout.CENTER);
			f.add(button1, BorderLayout.SOUTH);
			f.setSize(400, 500);
			f.setVisible(true);
						
			// 전송 이벤트
			send.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// 서버로 tf 데이터 전송
//					System.out.println(tf.getText());
					try {
						output.writeUTF(tf.getText());
						tf.setText(id);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			});
			
			// 종료 이벤트
			button1.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					System.out.println("클라이언트 종료");
					try {
						output.writeUTF("exit");
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					System.exit(0);
				}
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}
}

class ServiceThread extends Thread{
	DataInputStream input;
	TextArea ta;
	
	public ServiceThread(DataInputStream input, TextArea ta) {
		this.input = input;
		this.ta = ta;
	}
	
	public void run() {
		try {
			while(true) {
				ta.append(input.readUTF() + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
