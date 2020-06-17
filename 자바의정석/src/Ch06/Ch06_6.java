package Ch06;

public class Ch06_6 {

	// 두 점 (x,y)와 (x1,y1)간의 거리를 구한다
	static double getDistance(int x, int y, int x1, int y1) {
//		return Math.sqrt((x1 - x) * (x1 - x) + (y1 - y) * (y1 - y));
		return Math.sqrt(Math.pow((x1-x), 2) + Math.pow((y1 - y), 2));  
	}
	
	public static void main(String args[]) {
		System.out.println(getDistance(1,1,2,2));
	}

}
