package Chapter6;

public class Ex06 {
	// 두 점의 거리를 계산하는 getDistance()를 완성
	
	// 두 점 (x,y)와 (x1,y1)간의 거리를 구한다
	// 제곱근 계산은 Math.sqrt(double a)를 사용
	// 제곱 계산은 Math.pow(double a, double b)를 사용
	static double getDistance(int x, int y, int x1, int y1) {
		return Math.sqrt(Math.pow(x-x1,2) + Math.pow(y-y1,2));
	}
	
	public static void main(String[] args) {
		System.out.println(getDistance(1,1,2,2));
	}
	
}
