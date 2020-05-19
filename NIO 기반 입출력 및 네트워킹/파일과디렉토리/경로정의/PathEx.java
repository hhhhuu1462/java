package 파일과디렉토리.경로정의;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

public class PathEx {

	public static void main(String[] args) {

		// Path 인터페이스

		Path path = Paths.get("C:\\lhs\\git\\java\\Project\\src\\Ex01\\ManagerGUI.java");
		System.out.println("[파일명] : " + path.getFileName());
		System.out.println("[부모 디렉토리명] : " + path.getParent().getFileName());
		System.out.println("[중첩 경로수] : " + path.getNameCount());

		System.out.println();

		// 중첩 경로수 만큼 반복
		for (int i = 0; i < path.getNameCount(); i++) {
			// 파일의 이름 출력
			System.out.println(path.getName(i));
		}

		System.out.println();

		Iterator<Path> iterator = path.iterator();
		while (iterator.hasNext()) {
			Path temp = iterator.next();
			System.out.println(temp.getFileName()); // 파일 또는 디렉토리 이름만 가진 Path 출력
		}

	}

}


