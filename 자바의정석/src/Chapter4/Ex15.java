package Chapter4;

public class Ex15 {
	public static void main(String[] args) {
		// 다음은 회문수를 구하는 프로그램이다 회문수란 숫자를 거꾸로 읽어도 앞으로 읽는 것과 같은 수를 말한다 . 
		// 예를 들면 ‘12321’이나 13531’ 같은 수를 말한다 .  
		int number = 12321;
		int tmp = number;
		int result =0; // number 변수 를 거꾸로 변환해서 담을 변수

		while(tmp !=0) {
			// result * 10 을 하는 이유 : 1의 자리를 만들어서 tmp % 10의 값을 넣기 위함
			result = result * 10 + tmp % 10;
			tmp /= 10;  // 위의 식에서 사용한 tmp의 마지막 자릿수 제거
		}

		if(number == result) {
			System.out.println( number + "는 회문수 입니다."); 
		} else {
			System.out.println( number + "는 회문수가 아닙니다.");	
		}
	}
}
