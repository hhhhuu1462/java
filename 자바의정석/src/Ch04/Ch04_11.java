package Ch04;

public class Ch04_11 {

	// �Ǻ���ġ ����
	public static void main(String[] args) {
		// Fibonnaci������ ������ ù �� ���ڸ� 1, 1�� �Ѵ�
		int num1 = 1;
		int num2 = 1;
		int num3 = 0; // ����° ��
		
		System.out.print(num1+", "+num2);
		
		for (int i = 0 ; i < 8 ; i++ ) {
			num3 = num1 + num2;
			System.out.print(", " + num3);
			
			num1 = num2;
			num2 = num3;
		}
	} // end of main
	
}
