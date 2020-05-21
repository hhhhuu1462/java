package Chapter7.Ex01Ex02;

/*
�޼���� : shuffle 
�� �� :  �迭 cards�� ��� ī���� ��ġ�� �ڼ��´� (Math.random() ���)
��ȯŸ�� : ���� 
�Ű����� : ����
 */

/*
�޼���� : pick
�� �� : �迭 cards���� ������ ��ġ�� SutdaCard�� ��ȯ�Ѵ�
��ȯŸ�� : SutdaCard
�Ű����� : int index - ��ġ
 */

/*
�޼���� : pick
�� �� : �迭 cards���� ������ ��ġ�� SutdaCard�� ��ȯ�Ѵ� (Math.random() ���)
��ȯŸ�� : SutdaCard
�Ű����� : ���� 
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

			// cards[i]�� cards[j]�� �� �ٲٱ�
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
		return pick(index); // pick(int index)�� ȣ���Ѵ�.
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
