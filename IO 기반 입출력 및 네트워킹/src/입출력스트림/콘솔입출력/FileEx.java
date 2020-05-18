package 콘솔입출력;

import java.io.File;
import java.net.URI;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileEx {
	
	public static void main(String[] args) throws Exception {
	
		File dir = new File("C:\\lhs\\연습자료\\Dir");
		File file1 = new File("C:\\lhs\\연습자료\\file1.txt");
		File file2 = new File("C:\\lhs\\연습자료\\file2.txt");
		File file3 = new File(new URI("file:///C:/lhs/연습자료/file3.txt")); // 파일 경로를 URI객체로 생성해서 매개값으로 제공
		
		if(dir.exists() == false) { dir.mkdirs(); } // 경로상에 없는 모든 디렉토리 생성
		if(file1.exists() == false) { file1.createNewFile(); } // 새로운 파일 생성
		if(file2.exists() == false) { file2.createNewFile(); }
		if(file3.exists() == false) { file3.createNewFile(); }
		
		File lhs = new File("C:\\lhs");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd   a   HH:mm");
		File[] contents = lhs.listFiles(); // 디렉토리에 포함된 목록 전체를 File 배열로 리턴
		
		System.out.println("날짜                시간       형태        크기           이름");
		System.out.println("-----------------------------------------------------------------------------------------------");
		for (File file : contents) {
			System.out.print(sdf.format(new Date(file.lastModified()))); // 마지막 수정 날짜
			if(file.isDirectory()) { // 디렉토리인지에 대한 여부
				System.out.print("\t<DIR>\t\t\t" + file.getName());
			} else {
				System.out.println("\t\t\t" + file.length() + "\t" + file.getName()); // 파일의 크기 + 파일의 이름 리턴
			}
			System.out.println();
		}
		
	}
	
}
