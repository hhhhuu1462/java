package Ch03;

public class Ch03_7 {

	// ȭ���� ������ ��ȯ�ϴ� �ڵ�
	//  ��ȯ���� : 'C =	5/9 ��(F - 32)'
	public static void main(String[] args) {
		int fahrenheit = 100; // ȭ��
		float celcius = (int) ((5 / 9f * (fahrenheit - 32)) * 100 + 0.5) / 100f ; // ����
		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);
	}

}
