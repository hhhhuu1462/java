package Ch03;

public class Ch03_9 {

	// ch�� �������̰ų� ������ ��쿡�� b�� ���� true�� �ǰ� �ϴ� �ڵ�
	public static void main(String[] args) {
		char ch = 'z';
		boolean b = ( (ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9') ? true : false );
		System.out.println(b);
	}

}
