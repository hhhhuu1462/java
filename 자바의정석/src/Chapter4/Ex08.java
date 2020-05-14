package Chapter4;

public class Ex08 {
	public static void main(String[] args) {
		// 방정식 2x+4y=10의 모든 해
		// 0<=x<=10, 0<=y<=10
		for (int x = 0; x <= 10; x++) {
			for (int y = 0; y <= 10; y++) {
				if(2*x + 4*y == 10) {
					System.out.println("x : " + x + "   y : " + y);
				}
			}
		}
	}
}
