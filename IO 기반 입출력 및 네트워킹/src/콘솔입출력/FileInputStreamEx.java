package �ܼ������;

import java.io.FileInputStream;

public class FileInputStreamEx {

	public static void main(String[] args) {
		
		try {
			FileInputStream fis = new FileInputStream("C:\\lhs\\java1\\java\\Project\\src\\Ex01\\ManagerGUI.java");
			int data;
			// 1����Ʈ�� �а� �ֿܼ� ���
			while ((data = fis.read()) != -1) {
				System.out.write(data);
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
