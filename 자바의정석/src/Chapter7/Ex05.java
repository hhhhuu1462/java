package Chapter7;

class Product {
	int price; // ��ǰ�� ����
	int bonusPoint; // ��ǰ���� �� �����ϴ� ���ʽ�����

	// �⺻ ������ �ݵ�� �ʿ�! 
	public Product() {
		// TODO Auto-generated constructor stub
	}
	
	Product(int price) {
		this.price = price;
		bonusPoint =(int)(price/10.0);
	}
}

class Tv extends Product {
	Tv() {}

	public String toString() {
		return "Tv";
	}
}

public class Ex05 {

	public static void main(String[] args) {
		Tv t = new Tv();
	}
	
}

// main ���� -> Tv() ���� -> Product()������ �Ǿ�� �ϴµ� �⺻ �����ڰ� ����
// �ڼ� Ŭ������ �����ڿ��� ���� Ŭ������ �����ڸ� ȣ���ؾ��ϴ� ����
//	:  ���� ���� ���ǵ� �ν��Ͻ� �������� �ʱ�ȭ�ǵ��� �ϱ� ���ؼ�