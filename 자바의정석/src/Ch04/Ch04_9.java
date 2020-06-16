package Ch04;

public class Ch04_9 {

	//  숫자로 이루어진 문자열 str이 있을 때 각 자리의 합을 더한 결과를 출력하는 코드
	// 문자열이 "12345"라면 ‘1+2+3+4+5’의 결과인 15를 출력
	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			int strInt = str.charAt(i) - '0'; // 문자 1 : 49, 문자 0 : 48
			sum += strInt;
		}
		
		System.out.println("sum : " + sum);
	}
	
}
