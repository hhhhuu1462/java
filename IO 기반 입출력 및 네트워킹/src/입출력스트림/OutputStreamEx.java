package 입출력스트림;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamEx {

	public static void main(String[] args) throws IOException {
		
		// OutputStream : 바이트 기반 출력 스트림의 최상위 추상 클래스
		
		OutputStream outputStream = new FileOutputStream("C:/lhs/연습자료/text1.txt");
		
		byte data[] = "ABC".getBytes();
		for (int i = 0; i < data.length; i++) {
			outputStream.write(data[i]); // "A", "B", "C" 를 하나씩 출력
		}
		
		outputStream.write(data); // "ABC" 모두 출력
		outputStream.write(data, 1, 2); // "BC"만 출력
		
		outputStream.flush(); // 버퍼에 잔류하고 있는 데이터를 모두 출력시키고 버퍼를 비움
		outputStream.close(); // OutputStream을 더 이상 사용하지 않을 경우
		
	}
	
}
