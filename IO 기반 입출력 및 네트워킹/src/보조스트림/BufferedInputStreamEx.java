package 보조스트림;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

public class BufferedInputStreamEx {

	public static void main(String[] args) throws Exception {
		
		long start = 0;
		long end = 0;
		
		FileInputStream fis1 = new FileInputStream("C:\\lhs\\연습자료\\a.jpg");
		start = System.currentTimeMillis();
		while(fis1.read() != -1) {} // 데이터 읽기
		end = System.currentTimeMillis();
		System.out.println("사용하지 않았을 때 : " + (end - start) + "ms");
		fis1.close();
		
		FileInputStream fis2 = new FileInputStream("C:\\lhs\\연습자료\\a.jpg");
		BufferedInputStream bis = new BufferedInputStream(fis2); // 버퍼 스트림 생성
		start = System.currentTimeMillis();
		while (bis.read() != -1) {} // 데이터 읽기 : 버퍼를 이용해서 읽기 때문에 버퍼에 저장 후 한 번에 읽는다
		end = System.currentTimeMillis();
		System.out.println("사용했을 때 : " + (end-start) + "ms");
		bis.close();
		fis2.close();
		
	}
	
}
