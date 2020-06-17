package Ch06;

public class Ch06_2 {

	public static void main(String args[]) {
		
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		
		System.out.println(card1.info()); // 3 출력
		System.out.println(card2.info()); // 1k 출력
		
	}

}

class SutdaCard {
	int num;
	boolean isKwang;
	
	String info() {
		return num + (isKwang == true ? "k" : "");
	}
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
}


