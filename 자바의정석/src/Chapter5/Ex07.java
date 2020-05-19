package Chapter5;

public class Ex07 {
	// 커맨드라인으로부터 거스름돈을 입력받아 동전의 개수 구하기

	public static void main(String[] args) {

		if(args.length!=1) {
			System.out.println("USAGE: java Exercise5_7 3120");
			System.exit(0);
		}
		
		// 문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다.
		int money = Integer.parseInt(args[0]);
		System.out.println("money="+money);
		
		int[] coinUnit = {500, 100, 50, 10 }; // 동전의 단위
		int[] coin = {5, 5, 5, 5}; // 단위별 동전의 개수
		
		for(int i=0;i<coinUnit.length;i++) {
			int coinNum = 0;
			
//			1. 금액(money) 을 동전단위로 나눠서 필요한 동전의 개수(coinNum) 를 구한다
			coinNum = money / coinUnit[i]; // 금액 / 동전 단위 -> 해당 동전으로 거슬러줄 수 있는 개수
			
//			2. 배열coin 에서 coinNum만큼의 동전을 뺀다
//			   만일 충분한 동전이 없다면 배열 coin에 있는 만큼만 뺀다
			if(coin[i] >= coinNum) { // 해당 동전의 개수가 가지고 있는 동전의 개수보다 작거나 같으면
				coin[i] -= coinNum; // 소유하고 있는 동전의 개수에서 필요한 만큼의 동전 개수를 뺀다.
			} else { // 해당 동전의 개수가 가지고 있는 동전의 개수보다 많으면
				coinNum = coin[i]; // 현재 가지고 있는 동전의 개수를 전달
				coin[i] = 0; // 현재 가지고 있는 동전의 개수는 0개
			}

//			3. 금액에서 동전의 개수coinNum 와 동전단위를 곱한 값을 뺀다
			money = money - coinNum * coinUnit[i];
			
			System.out.println(coinUnit[i]+"원 : "+coinNum); 
		}
		
		if(money > 0) {
			System.out.println("거스름돈이 부족합니다."); 
			System.exit(0); // 프로그램을 종료한다
		} else {
			System.out.println("= 남은 동전의 개수 ="); 
			
			for(int i=0;i<coinUnit.length;i++) {
				System.out.println(coinUnit[i]+"원 :"+coin[i]); 
			}
		}

	}

}

/*
 money=3120
500원 : 5
100원 : 5
50원 : 2
10원 : 2
= 남은 동전의 개수 =
500원 :0
100원 :0
50원 :3
10원 :3
*/
