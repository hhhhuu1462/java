package Ch05;

public class Ch05_5 {

	public static void main(String[] args) {
		
		// 1~9 ������ ���ڷ� �̷���� 3�ڸ� ���ڸ� ����� ���α׷� (�ߺ�X)
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];
		
		// ballArr . �迭 �� ������ ��Ҹ� ��� ��ġ�� �ٲ۴�
		for(int i=0; i< ballArr.length;i++) {
			int j = (int)(Math.random() * ballArr.length);
			int tmp = 0;
			
			
		}
		
		// ballArr 3 ball3 . �迭 �� �տ��� ���� ���� �迭 �� �����Ѵ�
		/* (2) */
		for(int i=0;i<ball3.length;i++) {
			System.out.print(ball3[i]);
		}
		
	} // end of main

}
