package Chapter6;

public class Ex08 {

	int kind;
	int num;
	
	static int width;
	static int height;
	
	Ex08(int k, int n) {
		kind = k;
		num = n;
	}

	public static void main(String[] args) {
		Ex08 card = new Ex08(1,1);
	}

}

// 클래스변수(static변수) : width, height
// 인스턴스변수 : kind, num
// 지역변수(local변수) : k, n, card, args -> 클래스 영역 이외의 영역