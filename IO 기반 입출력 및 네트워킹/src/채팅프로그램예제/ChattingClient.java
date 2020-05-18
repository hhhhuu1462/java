package ä�����α׷�����;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChattingClient extends Thread implements ActionListener {

	Frame frame;
	TextArea ta;
	TextField tf;
	TextField tf2;
	Dialog dialog;
	Label label;

	Socket s1;
	DataOutputStream dos;
	DataInputStream dis;
	boolean stop;
	String host;

	public ChattingClient() {
		launchFrame(); // ȭ�����
	}

	public void launchFrame() {
		frame = new Frame("�ϴ��� ä�� Ŭ���̾�Ʈ�� ");
		ta = new TextArea();
		tf = new TextField();
		frame.setBackground(Color.lightGray);
		ta.setEditable(false);
		frame.add(ta, BorderLayout.CENTER);
		frame.add(tf, BorderLayout.SOUTH);
		tf.addActionListener(this);
		frame.setSize(500, 300);
		frame.setVisible(true);
		tf.requestFocus();
		dialog = new Dialog(frame, "����IP", true);
		label = new Label("������ ���� IP�� �Է��ϼ���");
		tf2 = new TextField(15);
		dialog.add(label,BorderLayout.NORTH);
		dialog.add(tf2, BorderLayout.CENTER);
		tf2.addActionListener(this);
		dialog.pack();
		dialog.show();
		service(host);
		tf2.requestFocus();
	}

	public void service(String host){
		try {
			s1 = new Socket(host, 5001);
			dis = new DataInputStream(s1.getInputStream());
			dos = new DataOutputStream(s1.getOutputStream());
			ta.append("���� �Ϸ�...\n");
			this.start();

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(tf==e.getSource()) {
			try {
				String msg = tf.getText();
				ta.append(msg + "\n");
				if(msg.equals("exit")) {
					ta.append("byebye");
					stop = true;
					dos.close();
					s1.close();
					System.exit(0);
				} else {
					dos.writeUTF("���� : " + msg);
					tf.setText(" ");
				}
			} catch (IOException e1) {	}
		} /* end if */ else {
			host = tf2.getText().trim(); // �������� host�� ������ ip�ּ� �ֱ�
			if(host.equals("")) {
				host = "localhost";
			}
			dialog.dispose();
		}
	}


	@Override
	public void run() {
		System.out.println("Thread start!!! \n");
		try {
			while(!stop) {
				ta.append(dis.readUTF() + "\n");
			}
			dis.close();
			s1.close();
		} catch (EOFException e1) {
			System.out.println("�����κ��� ������ ������ϴ�");
		} catch (IOException e2) {
			e2.getStackTrace();
		}
	}

	public static void main(String[] args) {
		new ChattingClient();
	}

}
