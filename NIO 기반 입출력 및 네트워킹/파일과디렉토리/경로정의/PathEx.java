package ���ϰ����丮.�������;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PathEx {

	public static void main(String[] args) {

		// Path �������̽�

		Path path = Paths.get("C:\\lhs\\git\\java\\Project\\src\\Ex01\\ManagerGUI.java");
		System.out.println("[���ϸ�] : " + path.getFileName());
		System.out.println("[�θ� ���丮��] : " + path.getParent().getFileName());
		System.out.println("[��ø ��μ�] : " + path.getNameCount());

		System.out.println();

		// ��ø ��μ� ��ŭ �ݺ�
		for (int i = 0; i < path.getNameCount(); i++) {
			// ������ �̸� ���
			System.out.println(path.getName(i));
		}

		System.out.println();

		Iterator<Path> iterator = path.iterator();
		while (iterator.hasNext()) {
			Path temp = iterator.next();
			System.out.println(temp.getFileName()); // ���� �Ǵ� ���丮 �̸��� ���� Path ���
		}

	}

}


