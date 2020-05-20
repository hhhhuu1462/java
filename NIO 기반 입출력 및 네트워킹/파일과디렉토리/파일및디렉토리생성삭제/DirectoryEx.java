package 파일과디렉토리.파일및디렉토리생성삭제;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryEx {
	// 디렉토리 내용 얻기
	
	public static void main(String[] args) throws Exception {
		
		Path path1 = Paths.get("C:/Temp/subdir");
		Path path2 = Paths.get("C:/Temp/file.txt");
		
		// 경로상에 존재하지 않는 모든 디렉토리 생성
		if(Files.notExists(path1)) {
			Files.createDirectories(path1); 
		}
		
		// 파일 생성
		if(Files.notExists(path2)) {
			Files.createFile(path2);
		}
		
		Path path3 = Paths.get("C:/Temp");
		
		DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path3); // 디렉토리 내용을 스트림(반복자)으로 얻기
		
		for (Path path : directoryStream) {
			if (Files.isDirectory(path)) {
				System.out.println("[디렉토리] " + path.getFileName()); // 디렉토리 Path
			} else {
				System.out.println("[파일] " + path.getFileName() + "  [크기] " + Files.size(path));
			}
		}
		
	}
	
}
