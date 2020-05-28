package Chapter7;

class Product {
	int price; // 제품의 가격
	int bonusPoint; // 제품구매 시 제공하는 보너스점수

	// 기본 생성자 반드시 필요! 
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

// main 실행 -> Tv() 실행 -> Product()실행이 되어야 하는데 기본 생성자가 없음
// 자손 클래스의 생성자에서 조상 클래스의 생성자를 호출해야하는 이유
//	:  정답 조상에 정의된 인스턴스 변수들이 초기화되도록 하기 위해서