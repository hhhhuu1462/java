package Ch04;

public class Ch04_4 {

	
	// 1+(-2)+3+(-4)+... 와 같은 식으로 계속 더해나갔을 때, 몇까지 더해야 총합이 100 이상이 되는가
	public static void main(String[] args) {
		int sum = 0;
		int count = 0;
		for (int i = 1; ; i++) {
			sum+=i;
			i = -i;
			count++;
			if(sum >= 100) {
				break;
			}
		}
		System.out.println("count : " + count + "   sum : " + sum);
	}
	
}
