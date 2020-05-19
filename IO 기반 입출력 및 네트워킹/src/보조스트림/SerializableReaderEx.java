package 보조스트림;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class ClassA implements Serializable {
	// 직렬화 가능
	int field1;
	ClassB field2 = new ClassB();
	
	// 직렬화 불가능
	static int field3;
	transient int field4;
}

class ClassB implements Serializable {
	// 직렬화 가능
	int field1;
}

public class SerializableReaderEx {

	public static void main(String[] args) throws Exception {
		
		FileOutputStream fos = new FileOutputStream("C:/lhs/연습자료/Object.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		ClassA classA = new ClassA();
		classA.field1 = 1;
		classA.field2.field1 = 2;
		classA.field3 = 3;
		classA.field4 = 4;
		oos.writeObject(classA);
		oos.flush();
		oos.close();
		fos.close();
		
		FileInputStream fis = new FileInputStream("C:/lhs/연습자료/Object.dat");
		ObjectInputStream ois = new ObjectInputStream(fis);
		ClassA v = (ClassA) ois.readObject();
		System.out.println("field1 : " + v.field1);
		System.out.println("field2.field1 : " + v.field2.field1);
		System.out.println("field3 : " + v.field3);
		System.out.println("field4 : " + v.field4);
		
	}
	
}
