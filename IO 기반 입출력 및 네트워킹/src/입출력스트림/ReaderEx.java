package ����½�Ʈ��;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class ReaderEx {

	public static void main(String[] args) throws IOException {
		
		// Reader : ���� ��� �Է� ��Ʈ���� �ֻ��� �߻�Ŭ����
		//			  �Է� ��Ʈ�����κ��� �� ���� ����(2����Ʈ)�� �а� intŸ������ ����
		
		Reader reader = new FileReader("C:/lhs/�����ڷ�/text1.txt");
				int readData;
				while ((readData = reader.read()) != -1) {
					// �� �̻� �Է� ��Ʈ�����κ��� ���ڸ� ���� �� ���ٸ� -1����					  
					char charData = (char) readData;
					System.out.print(charData + "  ");
				}
		
		System.out.println();
		
		int readCharNo;
		char[] cbuf = new char[2];
		for (int i = 0; i < cbuf.length; i++) {
			if((readCharNo = reader.read(cbuf)) != -1) {
				// �� �̻� �Է� ��Ʈ�����κ��� ���ڸ� ���� �� ���ٸ� -1����
				System.out.print(cbuf[i] + "  ");
			}
		}
		
		reader.close();
		
	}
	
}
