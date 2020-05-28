package Chapter7;

class Buyer {
	int money = 1000;
	Product1[] cart = new Product1[3]; // ������ ��ǰ�� �����ϱ� ���� �迭
	int i = 0; // Product �迭 cart�� ���� index 
	
	void buy(Product1 p) {
		if(p.price > money) {
			System.out.println("���� �����մϴ�");
			return;
		}
		money -= p.price;
		add(p);
	}
	
	void add(Product1 p) {
		if(i>= cart.length) {
			Product1[] tmp = new Product1[cart.length*2];
			// �����ϰ��� �ϴ� �ҽ�, ó�� ���� �κ�, ���纻 ���, ���纻�� ����κк��� ����, �������� ���纻���� ��ŭ �о���� �Է�
			System.arraycopy(cart, 0,  tmp, 0, cart.length);
			cart = tmp;
		}
	} // add(Product p)
	
	void summary() {
	
	} // summary()
}

class Product1 {
	int price; // ��ǰ�� ����
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
