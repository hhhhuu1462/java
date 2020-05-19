package 보조스트림.SerialVersionUID;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerialVersionUIDEx2 {

	public static void main(String[] args) throws Exception {
		
		// 객체 역직렬화
		
		FileInputStream fis = new FileInputStream("C:/lhs/연습자료/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ClassC classC = (ClassC) ois.readObject();
		
		System.out.println("field1 : " + classC.field1);
		
	}
	
}
