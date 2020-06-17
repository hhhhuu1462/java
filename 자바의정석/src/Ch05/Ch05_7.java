package Ch05;

public class Ch05_7 {

	public static void main(String args[]) {
		
		if(args.length!=1) {
			System.out.println("USAGE: java Exercise5_7 3120");
			System.exit(0);
		}
		
		//  문자열을 숫자로 변환한다. 입력한 값이 숫자가 아닐 경우 예외가 발생한다
		int money = Integer.parseInt(args[0]);
		
		System.out.println("money="+money);
		
		int[] coinUnit = {500, 100, 50, 10 }; // 동전의 단위
		int[] coin = {5, 5, 5, 5}; // 단위별 동전의 개수
		
		for(int i=0;i<coinUnit.length;i++) {
			int coinNum = 0;
			coinNum = money / coinUnit[i]; // 필요한 동전의 개수
			
			if(coin[i] >= coinNum) { // 보유하고 있는 동전의 수가 같거나 많다면
				coin[i] = coin[i] - coinNum; // 남은 동전의 수 구하기 (보유 동전 수 - 사용한 동전 수)
			} else { // 보유 동전의 수 보다 많은 양의 동전이 필요하다면
				coinNum = coin[i]; // 현재 가지고 있는 동전 모두 사용
				coin[i] = 0; // 그 동전의 수 = 0
			}
			
			money = money - (coinNum * coinUnit[i]); // 나머지 받아야 할 돈 = 총 금액 - ( 동전의 개수 * 동전 금액 )
			
			System.out.println(coinUnit[i]+"원 : "+coinNum); 
		}
		
		if(money > 0) {
			System.out.println("거스름돈이 부족합니다."); 
			System.exit(0); // . 프로그램을 종료한다
		}
		
		System.out.println("= 남은 동전의 개수 ="); 
		for(int i=0;i<coinUnit.length;i++) {
			System.out.println(coinUnit[i]+"원 :"+coin[i]); 
		}
		
	} // main

}
