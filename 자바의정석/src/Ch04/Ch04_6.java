package Ch04;

public class Ch04_6 {
	
	// �� ���� �ֻ����� ������ �� ���� ���� 6�� �Ǵ� ��� ����� ��
	public static void main(String[] args) {
		int count = 0;
		for (int i = 1; i <= 6; i++) {
			for (int j = 1; j <= 6; j++) {
				if(i + j == 6) {
					System.out.println("(" + i + ", " + j + ")");
					count++;
				}
			}
		}
		System.out.println("count : " + count);
	}

}
