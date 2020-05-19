package 보조스트림;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class BufferedOutputStreamEx {

	public static void main(String[] args) throws Exception {
		
		FileInputStream fis = null;
		FileOutputStream fos = null;
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		int data = -1;
		long start = 0;
		long end = 0;
		fis = new FileInputStream("C:\\lhs\\연습자료\\a.jpg");
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("C:\\lhs\\java1\\java\\IO 기반 입출력 및 네트워킹\\src\\보조스트림\\aa.jpg");
		start = System.currentTimeMillis();
		while ((data = bis.read()) != -1) {
			fos.write(data); // FileOutputStream 직접 사용
		}
		fos.flush();
		end = System.currentTimeMillis();
		fos.close();
		bis.close();
		fis.close();
		System.out.println("사용하지 않았을 때 : " + (end - start) + "ms");
		
		fis = new FileInputStream("C:\\lhs\\연습자료\\a.jpg");
		bis = new BufferedInputStream(fis);
		fos = new FileOutputStream("C:\\lhs\\java1\\java\\IO 기반 입출력 및 네트워킹\\src\\보조스트림\\aa.jpg");
		bos = new BufferedOutputStream(fos);
		start = System.currentTimeMillis();
		while ((data = bis.read()) != -1) {
			bos.write(data); // BufferedOutputStream 사용
		}
		bos.flush();
		end = System.currentTimeMillis();
		bos.close();
		fos.close();
		bis.close();
		fis.close();
		System.out.println("사용했을 때 : " + (end - start) + "ms");
		
	}
	
}
