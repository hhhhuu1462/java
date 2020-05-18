package 보조스트림;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterEx {

	public static void main(String[] args) throws Exception {
		
		FileOutputStream fos = new FileOutputStream("C:\\lhs\\연습자료\\text.txt", true);
		Writer writer = new OutputStreamWriter(fos);
		
		String data = "\n바이트 출력 스트림을 문자 출력 스트림으로 변환 *메롱*";
		writer.write(data);
		
		writer.flush();
		writer.close();
		System.out.println("파일 저장이 끝났습니다");
		
	}
	
}
