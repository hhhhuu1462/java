package Chapter5;

public class Ex05 {
	public static void main(String[] args) {
		 // 1�� 9 ������ �ߺ����� ���� ���ڷ� �̷���� 3�ڸ� ���ڸ� ������ ���α׷�
		int[] ballArr = {1,2,3,4,5,6,7,8,9};
		int[] ball3 = new int[3];
		
		// ballArr . �迭 �� ������ ��Ҹ� ��� ��ġ�� �ٲ۴�
		for(int i=0; i< ballArr.length;i++) {
		int j = (int)(Math.random() * ballArr.length);
		int tmp = 0;
		
		tmp = ballArr[i];
		ballArr[i] = ballArr[j];
		ballArr[j] = tmp;

		}
		
		// ballArr 3 ball3 . �迭 �� �տ��� ���� ���� �迭 �� �����Ѵ�
		System.arraycopy(ballArr,0, ball3,0,3);
		
		for(int i=0;i<ball3.length;i++) {
		System.out.print(ball3[i]);
		}

	}
}
