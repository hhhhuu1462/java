package ����½�Ʈ��;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamEX {
	
	public static void main(String[] args) throws IOException {
		
		// InputStream : ����Ʈ ��� �Է� ��Ʈ���� �ֻ��� Ŭ���� -> �߻� Ŭ����
		InputStream inputStream = new FileInputStream("C:/lhs/�����ڷ�/a.jpg");
		int readByte;
		while ((readByte = inputStream.read()) != -1) { 
			// read() : 1����Ʈ�� �а� intŸ������ ����
			// 			�Է� ��Ʈ�����κ��� ����Ʈ�� ���� �� ���ٸ� -1 ����
			System.out.print("readByte : " + readByte + "  ");
		}
		inputStream.close();
		System.out.println();
		
		InputStream inputStream1 = new FileInputStream("C:/lhs/�����ڷ�/a.jpg");
		int readByteNo;
		byte[] readBytes = new byte[100];
		for (int i = 0; i < readBytes.length; i++) {
			if((readByteNo = inputStream1.read(readBytes)) != -1) {
				// read(byte[] b) : �� �� ���� �� �Ű������� �־��� ����Ʈ �迭 ���̸�ŭ ����
				// 					 �Է� ��Ʈ�����κ��� ����Ʈ�� ���� �� ���ٸ� -1 ����
				System.out.print("readBytes : " + readBytes[i] + "  ");
			}
		}
		inputStream1.close(); // InputStream�� �� �̻� ������� ���� ��� ȣ��
		System.out.println();
		
		InputStream inputStream2 = new FileInputStream("C:/lhs/�����ڷ�/a.jpg");
		byte[] readBytes1 = new byte[100];
		for (int i = 0; i < readBytes1.length; i++) {
			if((readByteNo = inputStream2.read(readBytes1, 0, 100)) != -1) {
				// read(byte[] b, int off, int len) : �Է� ��Ʈ�����κ��� len���� ����Ʈ��ŭ �а�, �Ű������� �־��� ����Ʈ �迭 b[off]���� len������ ����
				//										�׸��� ���� ����Ʈ ���� len���� ����
				// 									   �Է� ��Ʈ�����κ��� ����Ʈ�� ���� �� ���ٸ� -1 ����
				System.out.print("readBytes1 : " + readBytes1[i] + "  ");
			}
		}
		
	}
	
}