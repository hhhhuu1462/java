package �ܼ������;

import java.io.InputStream;

public class SystemInEx {

	public static void main(String[] args) throws Exception {

		System.out.println("== �޴� ==");
		System.out.println("1. ���� ��ȸ");
		System.out.println("2. ���� ���");
		System.out.println("3. ���� �Ա�");
		System.out.println("4. ���� �ϱ�");
		System.out.print("5. �޴��� �����ϼ��� >> ");

		InputStream inputStream = System.in; // Ű���� �Է� ��Ʈ�� ���
		char inputChar = (char) inputStream.read(); // �ƽ�Ű �ڵ带 �а� ���ڷ� ����

		switch (inputChar) {
		case '1' :
			System.out.println("���� ��ȸ�� �����ϼ̽��ϴ�.");
			break;
		case '2' :
			System.out.println("���� ����� �����ϼ̽��ϴ�.");
			break;
		case '3' :
			System.out.println("���� �Ա��� �����ϼ̽��ϴ�.");
			break;
		case '4' :
			System.out.println("���� �ϱ⸦ �����ϼ̽��ϴ�.");
			break;
		default :
			System.out.println("�� �� �Է��ϼ̽��ϴ�.");
		}

	}

}
