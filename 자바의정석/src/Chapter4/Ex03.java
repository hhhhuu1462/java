package Chapter4;

public class Ex03 {

	public static void main(String[] args) {
		
		// 1+(1+2)+(1+2+3)+(1+2+3+4)+...+(1+2+3+...+10) 의 결과를 계산하시오
		
		int sum = 0;
		int totalSum = 0;
		
		for (int i = 1; i <= 10; i++) {
			sum += i;
			totalSum += sum;
		}
		System.out.println(totalSum);		
		
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; i++) {
				if(i + j == 6) {
					System.out.println("(" + i + "," + j + ")");
				}
			}			
		}
	}	
}
