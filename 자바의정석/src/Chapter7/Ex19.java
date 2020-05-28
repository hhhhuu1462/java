package Chapter7;

class Buyer {
	int money = 1000;
	Product1[] cart = new Product1[3]; // 구입한 제품을 저장하기 위한 배열
	int i = 0; // Product 배열 cart에 사용될 index 
	
	void buy(Product1 p) {
		if(p.price > money) {
			System.out.println("돈이 부족합니다");
			return;
		}
		money -= p.price;
		add(p);
	}
	
	void add(Product1 p) {
		if(i>= cart.length) {
			Product1[] tmp = new Product1[cart.length*2];
			// 복사하고자 하는 소스, 처음 읽을 부분, 복사본 대상, 복사본의 어느부분부터 쓸지, 원본에서 복사본까지 얼마큼 읽어올지 입력
			System.arraycopy(cart, 0,  tmp, 0, cart.length);
			cart = tmp;
		}
	} // add(Product p)
	
	void summary() {
	
	} // summary()
}

class Product1 {
	int price; // 제품의 가격
	Product1(int price) {
		this.price = price;
	}
}

class Tv1 extends Product1 {
	Tv1() { super(100); }
	public String toString() { return "Tv"; }
}

class Computer extends Product1 {
	Computer() { super(200); }
	public String toString() { return "Computer";}
}

class Audio extends Product1 {
	Audio() { super(50); }
	public String toString() { return "Audio"; }
}

public class Ex19 {

	public static void main(String args[]) {

		Buyer b = new Buyer();

		b.buy(new Tv1());
		b.buy(new Computer());
		b.buy(new Tv1());
		b.buy(new Audio());
		b.buy(new Computer());
		b.buy(new Computer());
		b.buy(new Computer());
		b.summary();

	}


}
