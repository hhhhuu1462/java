package ���ϰ����丮.���Ͻý�������;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileSystemEx {

	public static void main(String[] args) throws Exception {

		// ���� �ý��� ���� ���

		FileSystem fileSystem = FileSystems.getDefault();

		for (FileStore store : fileSystem.getFileStores()) { // ����̹� ������ ���� FileStore ��ü���� ����
			System.out.println("����̹��� : " + store.name());	
			System.out.println("���Ͻý��� : " + store.type());	
			System.out.println("��ü ���� : " + store.getTotalSpace() + " ����Ʈ");	
			System.out.println("������� ���� : " + (store.getTotalSpace() - store.getUnallocatedSpace()) + " ����Ʈ");	
			System.out.println("��� ������ ���� : " + store.getUsableSpace() + " ����Ʈ");	
			System.out.println();	
		}

		System.out.println("���� ������ : " + fileSystem.getSeparator());
		System.out.println();

		for (Path path : fileSystem.getRootDirectories()) { //��Ʈ ���丮 ������ ���� Path ��ü���� ����
			System.out.println(path.toString());			
		}

	}

}
