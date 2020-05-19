package 네트워크기초.데이터보내고받기;

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
				System.out.println("[연결 기다림]");
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결 수락함] " + isa.getHostName());

				byte[] bytes = null;
				String message = null;

				// 2. 서버가 이 데이터를 받고
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				int readByteCount = is.read(bytes);
				message = new String(bytes, 0, readByteCount, "UTF-8");
				System.out.println("[데이터 받기 성공] : " + message);

				// 3. "Hello Client"를 클라이언트로 보내면
				OutputStream os = socket.getOutputStream();
				message = "Hello Client";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[데이터 보내기 성공]");

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
[연결 기다림]
[연결 수락함] activate.adobe.com
[데이터 받기 성공] : Hello Server
[데이터 보내기 성공]
[연결 기다림]
*/
