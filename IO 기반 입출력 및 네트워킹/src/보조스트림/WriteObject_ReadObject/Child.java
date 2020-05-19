package 보조스트림.WriteObject_ReadObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Child extends Parent implements Serializable {
	public String field2;
	
	// 부모 클래스의 필드를 직렬화 하기 위해선
	// 부모 객체의 필드를 직접 출력
	private void writeObject(ObjectOutputStream out) throws Exception {
		out.writeUTF(field1);
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		field1 = in.readUTF();
		in.defaultReadObject();
	}
}
