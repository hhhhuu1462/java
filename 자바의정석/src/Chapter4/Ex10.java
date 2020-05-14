package Chapter4;

public class Ex10 {
	public static void main(String[] args) {
		// int 타입의 변수 num이 있을 때 각 자리의 합을 더한 결과를 출력하는 코드
		int num = 12345;
		int sum = 0;
		
		while (num > 0) {
			sum += num % 10; // num을 10으로 나눈 나머지를 더한 후
			num /= 10; // num을 10으로 나누는 반복문
		}
		System.out.println("sum="+sum);
	}
}
