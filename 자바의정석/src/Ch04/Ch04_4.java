package Ch04;

public class Ch04_4 {

	
	// 1+(-2)+3+(-4)+... �� ���� ������ ��� ���س����� ��, ����� ���ؾ� ������ 100 �̻��� �Ǵ°�
	public static void main(String[] args) {
		int sum = 0;
		int count = 0;
		for (int i = 1; ; i++) {
			sum+=i;
			i = -i;
			count++;
			if(sum >= 100) {
				break;
			}
		}
		System.out.println("count : " + count + "   sum : " + sum);
	}
	
}
