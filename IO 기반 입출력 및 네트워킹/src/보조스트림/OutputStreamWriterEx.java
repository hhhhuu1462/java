package ������Ʈ��;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OutputStreamWriterEx {

	public static void main(String[] args) throws Exception {
		
		FileOutputStream fos = new FileOutputStream("C:\\lhs\\�����ڷ�\\text.txt", true);
		Writer writer = new OutputStreamWriter(fos);
		
		String data = "\n����Ʈ ��� ��Ʈ���� ���� ��� ��Ʈ������ ��ȯ *�޷�*";
		writer.write(data);
		
		writer.flush();
		writer.close();
		System.out.println("���� ������ �������ϴ�");
		
	}
	
}
