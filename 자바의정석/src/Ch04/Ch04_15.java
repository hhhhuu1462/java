package Ch04;

public class Ch04_15 {

	public static void main(String[] args) {

		// 회문수를 구하는 프로그램
		// 숫자를 거꾸로 읽어도 앞으로 읽는 것과 같은 수
		int number = 12321;
		int tmp = number;
		int result =0; // number 변수 를 거꾸로 변환해서 담을 변수
		
		while(tmp !=0) {
			result = result * 10 + tmp % 10; // 기존 결과에 10을 곱해서 더하기
			tmp /= 10;
		}
		
		if(number == result) {
			System.out.println( number + "는 회문수 입니다.");
		} else {
			System.out.println( number + "는 회문수가 아닙니다."); 
		}

	} // main

}
