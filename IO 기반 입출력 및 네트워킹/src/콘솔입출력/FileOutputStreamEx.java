package 콘솔입출력;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileOutputStreamEx {

	public static void main(String[] args) throws Exception {
		
		String originalFileName = 
				"C:\\lhs\\java1\\java\\Project\\src\\Ex01\\MemberDAO.java";
		String targetFileName = "C:\\lhs\\연습자료\\a.jpg";
		
		FileInputStream fis = new FileInputStream(originalFileName);
		FileOutputStream fos = new FileOutputStream(targetFileName);
		
		int readByteNo; // 실제로 읽은 바이트 수가 저장될 변수
		byte[] readBytes = new byte[100]; // 실제로 읽은 바이트가 저장되는 배열
		while ((readByteNo = fis.read(readBytes)) != -1) { // 한 번에 100바이트를 읽어 readBytes에 저장, readByteNo에 100 저장
			fos.write(readBytes, 0, readByteNo); // 실제로 읽은 바이트 수만큼만 fos의 write메소드로 저장
		}
		
		fos.flush();
		fos.close();
		fis.close();
		
		System.out.println("복사가 잘 되었습니다");
		
	}
	
}
