package ������Ʈ��.SerialVersionUID;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SerialVersionUIDEx {

	public static void main(String[] args) throws Exception {
		
		// ��ü ����ȭ
		
		FileOutputStream fos = new FileOutputStream("C:/lhs/�����ڷ�/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		ClassC classC = new ClassC();
		classC.field1 = 1;
		oos.writeObject(classC);
		
		oos.flush();
		oos.close();
		fos.close();
		
	}
	
}
