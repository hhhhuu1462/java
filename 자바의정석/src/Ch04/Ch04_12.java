package Ch04;

public class Ch04_12 {

	public static void main(String[] args) {
		for (int i = 1; i <= 3; i++) {
			for (int j = 2; j <= 4; j++) {
				System.out.print(j + " * " + i + " = " + j*i + "\t\t");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 1; i <= 3; i++) {
			for (int j = 5; j <= 7; j++) {
				System.out.print(j + " * " + i + " = " + j*i + "\t\t");
			}
			System.out.println();
		}
		System.out.println();
		
		for (int i = 1; i <= 3; i++) {
			for (int j = 8; j <= 9; j++) {
				System.out.print(j + " * " + i + " = " + j*i + "\t\t");
			}
			System.out.println();
		}
	}
	
}
