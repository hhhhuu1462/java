package Chapter7.Ex01Ex02;

/*
메서드명 : shuffle 
기 능 :  배열 cards에 담긴 카드의 위치를 뒤섞는다 (Math.random() 사용)
반환타입 : 없음 
매개변수 : 없음
 */

/*
메서드명 : pick
기 능 : 배열 cards에서 지정된 위치의 SutdaCard를 반환한다
반환타입 : SutdaCard
매개변수 : int index - 위치
 */

/*
메서드명 : pick
기 능 : 배열 cards에서 임의의 위치의 SutdaCard를 반환한다 (Math.random() 사용)
반환타입 : SutdaCard
매개변수 : 없음 
 */

class SutdaDeck1 {

	final int CARD_NUM = 20;
	SutdaCard1[] cards = new SutdaCard1[CARD_NUM];

	SutdaDeck1() {
		for (int i = 0; i < cards.length; i++) {
			int num = i %10 + 1;  // i = 0 -> 1, i = 1 -> 2 ...
			boolean isKwang = (i < 10) && (num == 1 || num == 3 || num == 8);

			cards[i] = new SutdaCard1(num, isKwang);
		}
	}

	void shuffle() {
		for (int i = 0; i < cards.length; i++) {
			int j = (int)(Math.random() * cards.length);

			// cards[i]와 cards[j]의 값 바꾸기
			SutdaCard1 tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;
		}
	}

	SutdaCard1 pick(int index) {
		if (index < 0 || index > CARD_NUM) {
			return null;
		}
		return cards[index];
	}

	SutdaCard1 pick() {
		int index = (int)(Math.random() * cards.length);
		return pick(index); // pick(int index)를 호출한다.
	}

} // SutdaDeck

class SutdaCard1 {

	int num;
	boolean isKwang;

	SutdaCard1() {
		this(1, true);
	}

	SutdaCard1(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public String toString() {
		return num + ( isKwang ? "K":"");
	}

}

public class Ex02 {

	public static void main(String args[]) {

		SutdaDeck1 deck = new SutdaDeck1();

		System.out.println(deck.pick(0));
		System.out.println(deck.pick());

		deck.shuffle();

		for(int i=0; i < deck.cards.length;i++) {
			System.out.print(deck.cards[i]+", ");
		}

		System.out.println();
		System.out.println(deck.pick(0));

	}

}
