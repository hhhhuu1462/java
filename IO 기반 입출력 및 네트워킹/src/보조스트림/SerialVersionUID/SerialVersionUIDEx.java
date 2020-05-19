package 보조스트림.SerialVersionUID;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerialVersionUIDEx {

	public static void main(String[] args) throws Exception {
		
		// 객체 직렬화
		
		FileOutputStream fos = new FileOutputStream("C:/lhs/연습자료/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		ClassC classC = new ClassC();
		classC.field1 = 1;
		oos.writeObject(classC);
		
		oos.flush();
		oos.close();
		fos.close();
		
	}
	
}
