package Ch05;

public class Ch05_6 {

	public static void main(String args[]) {
		
		// 거스름돈을 몇 개의 동전으로 지불할 수 있는지를 계산하는 문제
		// . 큰 금액의 동전을 우선적으로 거슬러 줘야한다
		int[] coinUnit = {500, 100, 50, 10};
		int money = 2680;
		
		System.out.println("money="+money);
		
		for(int i=0;i<coinUnit.length;i++) {
			System.out.println(coinUnit[i] + "원 : " + money / coinUnit[i] + "개");
			money = money % coinUnit[i];
		}
		
	} // main

}
