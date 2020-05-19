package 네트워크기초.데이터보내고받기;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientEx {

	public static void main(String[] args) throws Exception {

		Socket socket = null;
		try {
			socket = new Socket();
			System.out.println("[연결 요청]");
			socket.connect(new InetSocketAddress("localhost", 5007));
			System.out.println("[연결 성공]");

			byte[] bytes = null;
			String message = null;

			// 1. 클라이언트가 먼저 "Hello Server"를 서버로 보낸다
			OutputStream os = socket.getOutputStream();
			message = "Hello Server";
			bytes = message.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("[데이터 보내기 성공]");

			// 4. 클라이언트가 이 데이터를 받는다.
			InputStream is = socket.getInputStream();
			bytes = new byte[100];
			int readByteCount = is.read(bytes);
			message = new String(bytes, 0, readByteCount, "UTF-8");
			System.out.println("[데이터 받기 성공] : " + message);

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
[연결 요청]
[연결 성공]
[데이터 보내기 성공]
[데이터 받기 성공] : Hello Client
*/
