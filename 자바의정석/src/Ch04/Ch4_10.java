package Ch04;

public class Ch4_10 {

	// int Ÿ���� ���� num�� �� �ڸ��� ���� ���� ����� ����ϴ� �ڵ�
	public static void main(String[] args) {
		int num = 12345;
		int sum = 0;
		
		while (num > 0) {
			sum += num % 10; // num�� 10���� ���� �������� ���ϱ� (1�� �ڸ����� �������� ����)
			num /= 10; // �������� �������� ����� �������Ƿ� /10 �� �Ͽ� �ڸ��� ���ֱ�
		}
		
		System.out.println("sum="+sum);
	}

}
