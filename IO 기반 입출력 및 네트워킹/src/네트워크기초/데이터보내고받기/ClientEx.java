package ��Ʈ��ũ����.�����ͺ�����ޱ�;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientEx {

	public static void main(String[] args) throws Exception {

		Socket socket = null;
		try {
			socket = new Socket();
			System.out.println("[���� ��û]");
			socket.connect(new InetSocketAddress("localhost", 5007));
			System.out.println("[���� ����]");

			byte[] bytes = null;
			String message = null;

			// 1. Ŭ���̾�Ʈ�� ���� "Hello Server"�� ������ ������
			OutputStream os = socket.getOutputStream();
			message = "Hello Server";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[������ ������ ����]");

			// 4. Ŭ���̾�Ʈ�� �� �����͸� �޴´�.
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByteCount = is.read(bytes);
			message = new String(bytes, 0, readByteCount, "UTF-8");
			System.out.println("[������ �ޱ� ����] : " + message);

			os.close();
			is.close();
		} catch (Exception e) {
			// TODO: handle exception
		}

		if (!socket.isClosed()) {
			socket.close();
		}

	}

}

/*
[���� ��û]
[���� ����]
[������ ������ ����]
[������ �ޱ� ����] : Hello Client
*/
