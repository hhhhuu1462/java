package 보조스트림;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectInputOutputStreamEx {

	public static void main(String[] args) throws Exception {
		
		FileOutputStream fos = new FileOutputStream("C:\\lhs\\연습자료\\b.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		oos.writeObject(new Integer(10));
		oos.writeObject(new Double(3.14));
		oos.writeObject(new int[] {1, 2, 3, 4});
		oos.writeObject(new String("홍길동"));
		
		oos.flush();
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("C:\\lhs\\연습자료\\b.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		// 여러 객체를 저장 했을 경우 풀력된 객체 순서와 동일한 순서로 객체를 읽어야 한다.
		Integer obj1 = (Integer) ois.readObject();
		Double obj2 = (Double) ois.readObject();
		int[] obj3 = (int[] ) ois.readObject();
		String obj4 = (String) ois.readObject();
		
		ois.close();
		fis.close();
		
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj3[0] +", " + obj3[1] + ", " + obj3[2]);
		System.out.println(obj4);
		
	}
	
}
