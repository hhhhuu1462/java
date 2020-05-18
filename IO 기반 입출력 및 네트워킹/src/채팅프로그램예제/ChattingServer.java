package 채팅프로그램예제;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChattingServer extends Thread {

	Frame frame;
	TextArea textArea;
	TextField textFiled;
	ServerSocket serverSocket;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	boolean stop;

	public ChattingServer() throws Exception {
		launchFrame(); // 화면 구현
		service(); // 서버 연결
	}

	public void launchFrame() {
		frame = new Frame("1:1 채팅");
		textArea = new TextArea();
		textFiled = new TextField();
		frame.setBackground(Color.LIGHT_GRAY);
		textArea.setEditable(false);
		frame.add(textArea, BorderLayout.CENTER);
		frame.add(textFiled, BorderLayout.SOUTH);
		textFiled.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String message = textFiled.getText();
					textArea.append(message + "\n");
					if(message.equals("exit")) {
						textArea.append("bye");
						stop = true;
						dos.close();
						socket.close();
						System.exit(0);
					} else {
						dos.writeUTF("서버 : " + message); // 스트림 만들기
						textFiled.setText("");
					}
				} catch (Exception e1) {
					e1.getStackTrace();
				}
			}
		});
		frame.setSize(500, 300);
		frame.setVisible(true);
		textFiled.requestFocus();
	} // end launchFrame()

	public void service() throws Exception {
		textArea.append("서비스 하기 위해 준비중...\n");
		serverSocket = new ServerSocket(5001); // 포트번호 설정
		textArea.append("클라이언트 접속 대기중...\n");
		socket = serverSocket.accept(); // 요청에 의한 수락 대기중

		textArea.append("클라이언트가 접속하였습니다" + socket.getInetAddress() + "\n");
		dos = new DataOutputStream(socket.getOutputStream());
		dis = new DataInputStream(socket.getInputStream());
		this.start();
		dos.writeUTF("채팅 서버에 접속하신 걸 환영합니다");
	}

	@Override
	public void run() {
		try {
			while (!stop) {
				textArea.append(dis.readUTF() + "\n");
			}
			dis.close();
			socket.close();
			} catch (EOFException e) {
				System.out.println("클라이언트로부터 연결이 끊겼습니다 \n");
			} catch (Exception e) {
				e.getStackTrace();
			}
	}


	public static void main(String[] args) throws Exception {
		new ChattingServer();
	}

}
