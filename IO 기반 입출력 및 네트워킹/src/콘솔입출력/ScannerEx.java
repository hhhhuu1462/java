package 콘솔입출력;

import java.util.Scanner;

public class ScannerEx {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		// Console 클래스와는 달리 문자열 뿐만 아니라 기본타입값을 바로 읽을 수 있다.
		
		System.out.print("문자열 입력 > ");
		String inputString = scanner.nextLine();
		System.out.println(inputString);
		System.out.println();
		
		System.out.print("정수 입력 > ");
		int inputInt = scanner.nextInt();
		System.out.println(inputInt);
		System.out.println();
		
		System.out.print("실수 입력 > ");
		double inputDouble = scanner.nextDouble();
		System.out.println(inputDouble);
		
	}
	
}
