package Ch04;

public class Ch4_10 {

	// int 타입의 변수 num의 각 자리의 합을 더한 결과를 출력하는 코드
	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		
		while (num > 0) {
			sum += num % 10; // num을 10으로 나눈 나머지를 구하기 (1의 자리부터 구해지는 루프)
			num /= 10; // 나머지를 구했으면 사용이 끝났으므로 /10 을 하여 자릿수 없애기
		}
		
		System.out.println("sum="+sum);
	}

}
