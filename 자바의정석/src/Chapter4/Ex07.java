package Chapter4;

public class Ex07 {
	public static void main(String[] args) {
		//  Math.random() 1 6 value 을 이용해서 부터 사이의 임의의 정수를 변수 에 저장
		int value = (int)(Math.random() * 6) + 1;
		System.out.println("value:"+value);
	}
}
