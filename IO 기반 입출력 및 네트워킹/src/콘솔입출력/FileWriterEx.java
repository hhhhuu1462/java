package �ܼ������;

import java.io.File;
import java.io.FileWriter;

public class FileWriterEx {

	public static void main(String[] args) throws Exception {
		
		File file = new File("C:\\lhs\\�����ڷ�\\text.txt");
		FileWriter fw = new FileWriter(file, true); // ���� ���� �����ϸ鼭 �ٿ��ֱ�
		fw.write("FileWriter�� �ѱ۷� �� " + "\r\n");
		fw.write("���ڿ��� �ٷ� ����� �� �ִ�." + "\r\n");
		fw.flush();
		fw.close();
		System.out.println("���Ͽ� ����Ǿ����ϴ�");
		
	}
	
}
