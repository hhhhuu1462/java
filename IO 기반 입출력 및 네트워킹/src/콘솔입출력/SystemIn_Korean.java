package �ܼ������;

import java.io.InputStream;

public class SystemIn_Korean {

	public static void main(String[] args) throws Exception {
		
		// �ֿܼ��� �Է��� �ѱ� �˾Ƴ���
		InputStream inputStream = System.in;
		
		byte[] datas = new byte[100];
		
		System.out.print("�̸� : ");
		int nameBytes = inputStream.read(datas); // ������ ���� ����Ʈ �� ����
		String name = new String(datas, 0, nameBytes-2);
		// ���� 2����Ʈ�� enterŰ�� �ش��ϴ� ĳ��������(13)�� �����ǵ�(10)�̹Ƿ� ���ڿ����� ����
		
		System.out.print("�ϰ� ������ : ");
		int commentBytes = inputStream.read(datas);
		String comment = new String(datas, 0, commentBytes-2);
		
		System.out.println("�Է��� �̸� : " + name);
		System.out.println("�Է��� comment : " + comment);
		
	}
	
}
