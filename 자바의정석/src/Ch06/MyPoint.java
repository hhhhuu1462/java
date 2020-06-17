package Ch06;

public class MyPoint {

	int x;
	int y;
	
	MyPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	double getDistance(int x1, int y1) {
		return Math.sqrt(Math.pow((x1-x),2) + Math.pow((y1-y),2));
	}
	
	public static void main(String args[]) {
		MyPoint p = new MyPoint(1,1);

		// p (2,2) . 와 의 거리를 구한다
		System.out.println(p.getDistance(2,2));
	}

}
