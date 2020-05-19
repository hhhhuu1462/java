package Chapter5;

public class Ex08 {
	// 배열 answer 에 담긴 데이터를 읽고 각 숫자의 개수를 세어서 개수만큼 '*' 을 찍어서 그래프를 그리는 프로그램

	public static void main(String[] args) {

		int[] answer = { 1,4,4,3,1,4,4,2,1,3,2 };
		int[] counter = new int[4];
		
		// answer 배열원소 1~4의 숫자의 갯수를 counter 배열에 담기
		for(int i=0; i < answer.length;i++) {
			counter[answer[i]-1]++;
		}
		
		for(int i=0; i < counter.length;i++) {
			System.out.print((i+1) + " : " + counter[i] + "개 >> ");
			
			for (int j = 0; j < counter[i]; j++) {
				System.out.print("*"); // counter[i]의 값 만큼 ‘*’ 을 찍는다
			}
			System.out.println();
		}

	}

}
