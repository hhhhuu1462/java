package Chapter6.Ex1Ex2;

// EX01 & Ex02

public class SutdaCard {
	// 다음과 같은 멤버변수를 갖는 클래스를 정의
	// 타입 : int  변수명 : num  설명 : 카드의 숫자 (1~10 사이의 정수)
	// 타입 : boolean  변수명 : isKwang  설명 : 광 이면 아니면 ( ) true, false 

	int num;
	boolean isKwang;
	
	public SutdaCard() {
		this.num = 1;
		this.isKwang = true;
	}
	
	public SutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}
	
	String info() {
		return num + (isKwang? "K" : "");
	}

	public static void main(String[] args) {
		SutdaCard card1 = new SutdaCard(3, false);
		SutdaCard card2 = new SutdaCard();
		System.out.println(card1.info());
		System.out.println(card2.info());

	}

}
