package ��Ʈ��ũ����.�����ͺ�����ޱ�;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {

	public static void main(String[] args) throws Exception {

		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket();
			serverSocket.bind(new InetSocketAddress("localhost", 5007));

			while (true) {
				System.out.println("[���� ��ٸ�]");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[���� ������] " + isa.getHostName());

				byte[] bytes = null;
				String message = null;

				// 2. ������ �� �����͸� �ް�
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes);
				message = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println("[������ �ޱ� ����] : " + message);

				// 3. "Hello Client"�� Ŭ���̾�Ʈ�� ������
				OutputStream os = socket.getOutputStream();
				message = "Hello Client";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[������ ������ ����]");

				is.close();
				os.close();
				socket.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		if(!serverSocket.isClosed()) {
			serverSocket.close();
		}

	}

}

/*
[���� ��ٸ�]
[���� ������] activate.adobe.com
[������ �ޱ� ����] : Hello Server
[������ ������ ����]
[���� ��ٸ�]
*/


