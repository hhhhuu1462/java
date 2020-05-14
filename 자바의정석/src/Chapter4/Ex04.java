package Chapter4;

public class Ex04 {
	public static void main(String[] args) {
		// 1+(-2)+3+(-4)+... 와 같은 식으로 계속 더해나갔을 때 몇까지 더해야 총합이 100 이상이 되는가
		
		int sum = 0; // 총 합을 저장할 변수
		int flag = 1; // 부호변환 변수
		int num = 0; // 
		
		for (int i = 1;true; i++) {
			num = flag * i;
			sum += num;
			
			if(sum >= 100) {
				break;
			}
			
			flag = -flag;
		}
		System.out.println(num);
		System.out.println(sum);
	}
}
