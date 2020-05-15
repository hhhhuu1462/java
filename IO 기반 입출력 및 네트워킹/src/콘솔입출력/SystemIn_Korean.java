package 콘솔입출력;

import java.io.InputStream;

public class SystemIn_Korean {

	public static void main(String[] args) throws Exception {
		
		// 콘솔에서 입력한 한글 알아내기
		InputStream inputStream = System.in;
		
		byte[] datas = new byte[100];
		
		System.out.print("이름 : ");
		int nameBytes = inputStream.read(datas); // 실제로 읽은 바이트 수 저장
		String name = new String(datas, 0, nameBytes-2);
		// 끝에 2바이트는 enter키에 해당하는 캐리지리턴(13)과 라인피드(10)이므로 문자열에서 제외
		
		System.out.print("하고 싶은말 : ");
		int commentBytes = inputStream.read(datas);
		String comment = new String(datas, 0, commentBytes-2);
		
		System.out.println("입력한 이름 : " + name);
		System.out.println("입력한 comment : " + comment);
		
	}
	
}
