package �ܼ������;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamEx {

	public static void main(String[] args) throws Exception {
		
		String originalFileName = 
				"C:\\lhs\\java1\\java\\Project\\src\\Ex01\\MemberDAO.java";
		String targetFileName = "C:\\lhs\\�����ڷ�\\a.jpg";
		
		FileInputStream fis = new FileInputStream(originalFileName);
		FileOutputStream fos = new FileOutputStream(targetFileName);
		
		int readByteNo; // ������ ���� ����Ʈ ���� ����� ����
		byte[] readBytes = new byte[100]; // ������ ���� ����Ʈ�� ����Ǵ� �迭
		while ((readByteNo = fis.read(readBytes)) != -1) { // �� ���� 100����Ʈ�� �о� readBytes�� ����, readByteNo�� 100 ����
			fos.write(readBytes, 0, readByteNo); // ������ ���� ����Ʈ ����ŭ�� fos�� write�޼ҵ�� ����
		}
		
		fos.flush();
		fos.close();
		fis.close();
		
		System.out.println("���簡 �� �Ǿ����ϴ�");
		
	}
	
}
