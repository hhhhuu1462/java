package �ܼ������;

import java.io.FileReader;

public class FileReaderEx {

	public static void main(String[] args) throws Exception {
		
		FileReader fr = new FileReader("C:\\lhs\\java1\\java\\Project\\src\\Ex01\\MemberDAO.java");
		
		int readCharNo;
		char[] cbuf = new char[100];
		while ((readCharNo = fr.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo); // cbuf�迭�� ����Ǿ� �ִ� ���ڵ��� �����ؼ� ���ڿ��� ����
			System.out.print(data);
		}
		fr.close();
		
	}

}
