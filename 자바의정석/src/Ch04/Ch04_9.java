package Ch04;

public class Ch04_9 {

	//  ���ڷ� �̷���� ���ڿ� str�� ���� �� �� �ڸ��� ���� ���� ����� ����ϴ� �ڵ�
	// ���ڿ��� "12345"��� ��1+2+3+4+5���� ����� 15�� ���
	public static void main(String[] args) {
		String str = "12345";
		int sum = 0;
		
		for (int i = 0; i < str.length(); i++) {
			int strInt = str.charAt(i) - '0'; // ���� 1 : 49, ���� 0 : 48
			sum += strInt;
		}
		
		System.out.println("sum : " + sum);
	}
	
}
