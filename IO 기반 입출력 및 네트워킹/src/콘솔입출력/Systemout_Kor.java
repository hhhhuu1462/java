package �ܼ������;

import java.io.InputStream;

public class Systemout_Kor {
	
	public static void main(String[] args) throws Exception {
		
		InputStream is = System.in;

		byte[] datas = new byte[100];

		System.out.print("�̸�: ");
		int nameBytes = is.read(datas); // ������ ���� ����Ʈ �� ����
		String name = new String(datas, 0, nameBytes-2); 
		// �� 2����Ʈ�� enterŰ�� �ش��ϴ� ĳ���� ����(13)�� �����ǵ�(10)�̹Ƿ� ���ڿ����� ����

		System.out.print("�ϰ� ������: ");
		int commentBytes = is.read(datas);
		String comment = new String(datas, 0, commentBytes-2);

		System.out.println("�Է��� �̸�: " + name);	
		System.out.println("�Է��� �ϰ� ������: " + comment);	
		
	}
	
}
