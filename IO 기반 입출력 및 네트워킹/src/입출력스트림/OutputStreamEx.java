package ����½�Ʈ��;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamEx {

	public static void main(String[] args) throws IOException {
		
		// OutputStream : ����Ʈ ��� ��� ��Ʈ���� �ֻ��� �߻� Ŭ����
		
		OutputStream outputStream = new FileOutputStream("C:/lhs/�����ڷ�/text1.txt");
		
		byte data[] = "ABC".getBytes();
		for (int i = 0; i < data.length; i++) {
			outputStream.write(data[i]); // "A", "B", "C" �� �ϳ��� ���
		}
		
		outputStream.write(data); // "ABC" ��� ���
		outputStream.write(data, 1, 2); // "BC"�� ���
		
		outputStream.flush(); // ���ۿ� �ܷ��ϰ� �ִ� �����͸� ��� ��½�Ű�� ���۸� ���
		outputStream.close(); // OutputStream�� �� �̻� ������� ���� ���
		
	}
	
}
