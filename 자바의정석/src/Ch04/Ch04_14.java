package Ch04;

import java.util.Scanner;

public class Ch04_14 {

	public static void main(String[] args) {
		
		// ���ڸ��߱� ����
		// 1~100 ������ ���� �ݺ������� �Է��ؼ� ��ǻ�Ͱ� ������ ���� ���߸� ���� ����
		// �� ������ ���ߴ��� �˷��ش�.
		
		// 1~100 ������ ������ ���� �� answer�� �����Ѵ�
		int answer =(int) (Math.random() * 100) + 1;
		int input = 0; // ������Է��� ������ ����
		int count = 0; // �õ�Ƚ���� �������� ����
		
		// Scanner ȭ������ ���� ������Է��� �ޱ� ���ؼ� Ŭ���� ���
		Scanner scanner = new Scanner(System.in);
		
		do {
			count++;
			System.out.println("1 100�� ������ ���� �Է��ϼ���:"); 
			input = scanner.nextInt(); // �Է¹��� ���� ���� input�� �����Ѵ�
			
			if (input > answer) {
				System.out.println("�� ���� ���� �Է��ϼ���");
			} else if (input < answer) {
				System.out.println("�� ū ���� �Է��ϼ���");
			} else {
				System.out.println("�����Դϴ�");
				System.out.println("�õ� Ƚ���� " + count + "�� �Դϴ�");
				break;				
			}
		} while(true); // ���ѹݺ���
		
	} // end of main

}
