package ����½�Ʈ��;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterEx {

	public static void main(String[] args) throws IOException {
		
		// Writer : ���� ��� ��� ��Ʈ���� �ֻ��� �߻�Ŭ����
		Writer writer = new FileWriter("C:/lhs/�����ڷ�/text.txt");
		char[ ] data = "ȫ�浿".toCharArray();
		for (int i = 0; i < data.length; i++) {
			writer.write(data[i]); // "ȫ", "��", "��"�� �ϳ��� ���
		}
		writer.flush();
		writer.close();
		
		Writer writer1 = new FileWriter("C:/lhs/�����ڷ�/text1.txt");
		char[] data1 = "ȫ�浿".toCharArray();
		writer1.write(data1); // "ȫ�浿" ��� ���
		writer1.flush();
		writer1.close();
		
		Writer writer2 = new FileWriter("C:/lhs/�����ڷ�/text2.txt");
		char[] data2 = "ȫ�浿".toCharArray();
		writer2.write(data2, 1, 2); // "�浿"�� ���
		writer2.flush();
		writer2.close();
		
		// Writer�� ���ڿ��� �� �� ���� �ϱ� ���� ������ ���� ��� ����
		Writer writer3 = new FileWriter("C:/lhs/�����ڷ�/text3.txt");
		writer3.write("����"); // "����" ��� ���
		writer3.flush();
		writer3.close();
		
		Writer writer4 = new FileWriter("C:/lhs/�����ڷ�/text4.txt");
		writer4.write("����", 1, 2); // "��"�� ���
		writer4.flush();
		writer4.close();
		
	}
	
}
