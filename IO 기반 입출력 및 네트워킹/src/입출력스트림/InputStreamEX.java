package 입출력스트림;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamEX {
	
	public static void main(String[] args) throws IOException {
		
		// InputStream : 바이트 기반 입력 스트림의 최상위 클래스 -> 추상 클래스
		InputStream inputStream = new FileInputStream("C:/lhs/연습자료/a.jpg");
		int readByte;
		while ((readByte = inputStream.read()) != -1) { 
			// read() : 1바이트를 읽고 int타입으로 리턴
			// 			입력 스트림으로부터 바이트를 읽을 수 없다면 -1 리턴
			System.out.print("readByte : " + readByte + "  ");
		}
		inputStream.close();
		System.out.println();
		
		InputStream inputStream1 = new FileInputStream("C:/lhs/연습자료/a.jpg");
		int readByteNo;
		byte[] readBytes = new byte[100];
		for (int i = 0; i < readBytes.length; i++) {
			if((readByteNo = inputStream1.read(readBytes)) != -1) {
				// read(byte[] b) : 한 번 읽을 때 매개값으로 주어진 바이트 배열 길이만큼 읽음
				// 					 입력 스트림으로부터 바이트를 읽을 수 없다면 -1 리턴
				System.out.print("readBytes : " + readBytes[i] + "  ");
			}
		}
		inputStream1.close(); // InputStream을 더 이상 사용하지 않을 경우 호출
		System.out.println();
		
		InputStream inputStream2 = new FileInputStream("C:/lhs/연습자료/a.jpg");
		byte[] readBytes1 = new byte[100];
		for (int i = 0; i < readBytes1.length; i++) {
			if((readByteNo = inputStream2.read(readBytes1, 0, 100)) != -1) {
				// read(byte[] b, int off, int len) : 입력 스트림으로부터 len개의 바이트만큼 읽고, 매개값으로 주어진 바이트 배열 b[off]부터 len개까지 저장
				//										그리고 읽은 바이트 수인 len개를 리턴
				// 									   입력 스트림으로부터 바이트를 읽을 수 없다면 -1 리턴
				System.out.print("readBytes1 : " + readBytes1[i] + "  ");
			}
		}
		
	}
	
}