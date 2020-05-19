package 보조스트림;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class DataInputOutputStreamEx {

	public static void main(String[] args) throws Exception {
		
		FileOutputStream fos = new FileOutputStream("C:\\lhs\\연습자료\\linedata.dat");
		DataOutputStream dos = new DataOutputStream(fos);
		
		dos.writeUTF("홍길동");
		dos.writeDouble(95.5);
		dos.writeInt(1);
		
		dos.writeUTF("김자바");
		dos.writeDouble(90.3);
		dos.writeInt(2);
		
		dos.flush();
		dos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("C:\\lhs\\연습자료\\linedata.dat");
		DataInputStream dis = new DataInputStream(fis);
		
		for (int i = 0; i < 2; i++) {
			// 출력 후 읽어올 때는 반드시 출력 순서와 동일한 순서로 읽어야 한다
			String name = dis.readUTF();
			double score = dis.readDouble();
			int order = dis.readInt();
			System.out.println(name + " : " + score + " : " + order);
		}
		
		dis.close();
		fis.close();
		
	}
	
}
