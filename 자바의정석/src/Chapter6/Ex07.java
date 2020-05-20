package Chapter6;

public class Ex07 {
	// Ex06에서 작성한 클래스 메소드 getDistance()를 Ex07클래스의 인스턴스 메소드로 정의
	
	int x;
	int y;
	
	public Ex07(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	double getDistance(int i, int j) {
		return Math.sqrt(Math.pow(i - x, 2) + Math.pow(j - y, 2));
	}
	
	public static void main(String[] args) {
		Ex07 p = new Ex07(1,1);
		
		// p (2,2) . 와 의 거리를 구한다
		System.out.println(p.getDistance(2,2));
	}

}
