package Chapter7.Ex01Ex02;

class SutdaDeck {
	final int CARD_NUM = 20;
	SutdaCard[] cards = new SutdaCard[CARD_NUM];
	SutdaDeck() {
		for (int i = 0; i < cards.length; i++) {
			int num = i %10 + 1;  // i = 0 -> 1, i = 1 -> 2 ...
			boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);
			
			cards[i] = new SutdaCard(num, isKwang);
		}
	}
}

class SutdaCard {
	final int NUM;
	final boolean IS_KWANG;
	
	SutdaCard() {
		this(1, true);
	}
	
	SutdaCard(int num, boolean isKwang) {
		this.NUM = num;
		this.IS_KWANG = isKwang;
	}
	
	// info() 대신 Object클래스의 toString()을 오버라이딩
	public String toString() {
		return NUM + ( IS_KWANG ? "K" : "");
	}
}

public class Ex01 {

	public static void main(String args[]) {
		SutdaDeck deck = new SutdaDeck();
		
		for(int i=0; i < deck.cards.length;i++) {
			System.out.print(deck.cards[i]+", ");
		}
	}


}
