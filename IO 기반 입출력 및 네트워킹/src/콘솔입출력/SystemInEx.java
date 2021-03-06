package 콘솔입출력;

import java.io.InputStream;

public class SystemInEx {

	public static void main(String[] args) throws Exception {

		System.out.println("== 메뉴 ==");
		System.out.println("1. 예금 조회");
		System.out.println("2. 예금 출금");
		System.out.println("3. 예금 입금");
		System.out.println("4. 종료 하기");
		System.out.print("5. 메뉴를 선택하세요 >> ");

		InputStream inputStream = System.in; // 키보드 입력 스트림 얻기
		// 콘솔창에 직접 입력 가능
		char inputChar = (char) inputStream.read(); // 아스키 코드를 읽고 문자로 리턴
		// 키보드를 입력하게 되면 아스키 코드값으로 읽히기 때문에 char 형변환 해주어야 

		switch (inputChar) {
		case '1' :
			System.out.println("예금 조회를 선택하셨습니다.");
			break;
		case '2' :
			System.out.println("예금 출금을 선택하셨습니다.");
			break;
		case '3' :
			System.out.println("예금 입금을 선택하셨습니다.");
			break;
		case '4' :
			System.out.println("종료 하기를 선택하셨습니다.");
			break;
		default :
			System.out.println("잘 못 입력하셨습니다.");
		}

	}

}
