package ������Ʈ��.WriteObject_ReadObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Child extends Parent implements Serializable {
	public String field2;
	
	// �θ� Ŭ������ �ʵ带 ����ȭ �ϱ� ���ؼ�
	// �θ� ��ü�� �ʵ带 ���� ���
	private void writeObject(ObjectOutputStream out) throws Exception {
		out.writeUTF(field1);
		out.defaultWriteObject();
	}
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		field1 = in.readUTF();
		in.defaultReadObject();
	}
}
