package Ch04;

public class Ch04_3 {

	// 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10)ÀÇ °á°ú
	public static void main(String[] args) {
		int sum = 0;
		int totalSum = 0;
		
		for (int i = 1; i <= 10; i++) {
			sum += i; // 1  1+2  1+2+3 ... 1+2+3+...+10
			totalSum += sum; // 1  1+(1+2)  1+(1+2)+(1+2+3)  1+(1+2)+(1+2+3)+...+(1+2+3+...+10)
		}
		
		System.out.println(totalSum);
	}
	
}
