package 파일과디렉토리.파일시스템정보;

import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileSystemEx {

	public static void main(String[] args) throws Exception {

		// 파일 시스템 정보 얻기

		FileSystem fileSystem = FileSystems.getDefault();

		for (FileStore store : fileSystem.getFileStores()) { // 드라이버 정보를 가진 FileStore 객체들을 리턴
			System.out.println("드라이버명 : " + store.name());	
			System.out.println("파일시스템 : " + store.type());	
			System.out.println("전체 공간 : " + store.getTotalSpace() + " 바이트");	
			System.out.println("사용중인 공간 : " + (store.getTotalSpace() - store.getUnallocatedSpace()) + " 바이트");	
			System.out.println("사용 가능한 공간 : " + store.getUsableSpace() + " 바이트");	
			System.out.println();	
		}

		System.out.println("파일 구분자 : " + fileSystem.getSeparator());
		System.out.println();

		for (Path path : fileSystem.getRootDirectories()) { //루트 디렉토리 정보를 가진 Path 객체들을 리턴
			System.out.println(path.toString());			
		}

	}

}
