package 입출력스트림;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterEx {

	public static void main(String[] args) throws IOException {
		
		// Writer : 문자 기반 출력 스트림의 최상위 추상클래스
		Writer writer = new FileWriter("C:/lhs/연습자료/text.txt");
		char[ ] data = "홍길동".toCharArray();
		for (int i = 0; i < data.length; i++) {
			writer.write(data[i]); // "홍", "길", "동"을 하나씩 출력
		}
		writer.flush();
		writer.close();
		
		Writer writer1 = new FileWriter("C:/lhs/연습자료/text1.txt");
		char[] data1 = "홍길동".toCharArray();
		writer1.write(data1); // "홍길동" 모두 출력
		writer1.flush();
		writer1.close();
		
		Writer writer2 = new FileWriter("C:/lhs/연습자료/text2.txt");
		char[] data2 = "홍길동".toCharArray();
		writer2.write(data2, 1, 2); // "길동"만 출력
		writer2.flush();
		writer2.close();
		
		// Writer은 문자열을 좀 더 쉽게 하기 위해 다음과 같이 사용 가능
		Writer writer3 = new FileWriter("C:/lhs/연습자료/text3.txt");
		writer3.write("이희성"); // "이희성" 모두 출력
		writer3.flush();
		writer3.close();
		
		Writer writer4 = new FileWriter("C:/lhs/연습자료/text4.txt");
		writer4.write("이희성", 1, 2); // "희성"만 출력
		writer4.flush();
		writer4.close();
		
	}
	
}
