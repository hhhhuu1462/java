package 보조스트림;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferedReaderEx {

	public static void main(String[] args) throws Exception {
		
		// 콘솔로부터 라인 단위로 읽기
		InputStream is = System.in;
		Reader reader = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(reader); // 버퍼스트림 생성
		
		System.out.print("입력 : ");
		String lineString = br.readLine();
		// readLine() : 캐리지리턴(\n)과 라인피드(\r)로 구분된 행 단위의 문자열을 한꺼번에 읽을 수 있다.
		
		System.out.println("출력 : " + lineString);
		
	}
	
}
