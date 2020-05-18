package ä�����α׷�����;

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
		launchFrame(); // ȭ�� ����
		service(); // ���� ����
	}

	public void launchFrame() {
		frame = new Frame("1:1 ä��");
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
						dos.writeUTF("���� : " + message); // ��Ʈ�� �����
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
		textArea.append("���� �ϱ� ���� �غ���...\n");
		serverSocket = new ServerSocket(5001); // ��Ʈ��ȣ ����
		textArea.append("Ŭ���̾�Ʈ ���� �����...\n");
		socket = serverSocket.accept(); // ��û�� ���� ���� �����

		textArea.append("Ŭ���̾�Ʈ�� �����Ͽ����ϴ�" + socket.getInetAddress() + "\n");
		dos = new DataOutputStream(socket.getOutputStream());
		dis = new DataInputStream(socket.getInputStream());
		this.start();
		dos.writeUTF("ä�� ������ �����Ͻ� �� ȯ���մϴ�");
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
				System.out.println("Ŭ���̾�Ʈ�κ��� ������ ������ϴ� \n");
			} catch (Exception e) {
				e.getStackTrace();
			}
	}


	public static void main(String[] args) throws Exception {
		new ChattingServer();
	}

}
