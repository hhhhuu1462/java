package ������Ʈ��;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamEx {

	public static void main(String[] args) throws Exception {
		
		long start = 0;
		long end = 0;
		
		FileInputStream fis1 = new FileInputStream("C:\\lhs\\�����ڷ�\\a.jpg");
		start = System.currentTimeMillis();
		while(fis1.read() != -1) {} // ������ �б�
		end = System.currentTimeMillis();
		System.out.println("������� �ʾ��� �� : " + (end - start) + "ms");
		fis1.close();
		
		FileInputStream fis2 = new FileInputStream("C:\\lhs\\�����ڷ�\\a.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2); // ���� ��Ʈ�� ����
		start = System.currentTimeMillis();
		while (bis.read() != -1) {} // ������ �б� : ���۸� �̿��ؼ� �б� ������ ���ۿ� ���� �� �� ���� �д´�
		end = System.currentTimeMillis();
		System.out.println("������� �� : " + (end-start) + "ms");
		bis.close();
		fis2.close();
		
	}
	
}
