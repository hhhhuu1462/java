package ������Ʈ��.SerialVersionUID;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class SerialVersionUIDEx2 {

	public static void main(String[] args) throws Exception {
		
		// ��ü ������ȭ
		
		FileInputStream fis = new FileInputStream("C:/lhs/�����ڷ�/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		
		ClassC classC = (ClassC) ois.readObject();
		
		System.out.println("field1 : " + classC.field1);
		
	}
	
}
