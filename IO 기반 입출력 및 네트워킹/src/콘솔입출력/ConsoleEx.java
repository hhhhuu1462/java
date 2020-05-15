package 콘솔입출력;

import java.io.Console;

public class ConsoleEx {

	public static void main(String[] args) {
		
		Console console = System.console();
		
		System.out.print("아이디 : ");
		String id = console.readLine();
		
		System.out.print("비밀번호 : ");
		char[] charPass = console.readPassword();
		String strPassword = new String(charPass); // char[] 배열을 문자열로 생성
		
		System.out.println("------------------------");
		System.out.println(id);
		System.out.println(strPassword);
		
	}
	
}
