package 콘솔입출력;

import java.io.FileReader;

public class FileReaderEx {

	public static void main(String[] args) throws Exception {
		
		FileReader fr = new FileReader("C:\\lhs\\java1\\java\\Project\\src\\Ex01\\MemberDAO.java");
		
		int readCharNo;
		char[] cbuf = new char[100];
		while ((readCharNo = fr.read(cbuf)) != -1) {
			String data = new String(cbuf, 0, readCharNo); // cbuf배열에 저장되어 있는 문자들을 연결해서 문자열로 생성
			System.out.print(data);
		}
		fr.close();
		
	}

}
