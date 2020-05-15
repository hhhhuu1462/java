package 입출력스트림;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderEx {

	public static void main(String[] args) throws IOException {
		
		// Reader : 문자 기반 입력 스트림의 최상위 추상클래스
		//			  입력 스트림으로부터 한 개의 문자(2바이트)를 읽고 int타입으로 리턴
		
		Reader reader = new FileReader("C:/lhs/연습자료/text1.txt");
				int readData;
				while ((readData = reader.read()) != -1) {
					// 더 이상 입력 스트림으로부터 문자를 읽을 수 없다면 -1리턴					  
					char charData = (char) readData;
					System.out.print(charData + "  ");
				}
		
		System.out.println();
		
		int readCharNo;
		char[] cbuf = new char[2];
		for (int i = 0; i < cbuf.length; i++) {
			if((readCharNo = reader.read(cbuf)) != -1) {
				// 더 이상 입력 스트림으로부터 문자를 읽을 수 없다면 -1리턴
				System.out.print(cbuf[i] + "  ");
			}
		}
		
		reader.close();
		
	}
	
}
