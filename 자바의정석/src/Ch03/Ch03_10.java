package Ch03;

public class Ch03_10 {

	// �빮�ڸ� �ҹ��ڷ� �����ϴ� �ڵ�
	// ch�� ���� �� ���ڰ� �빮���� ��쿡�� �ҹ��ڷ� ����
	// �����ڵ�� �ҹ��ڰ� �빮�ں��� 32��ŭ �� ũ��
	public static void main(String[] args) {
		char ch = 'A';
		char lowerCase = (ch >= 'A' && ch <= 'Z') ?  (char)(ch+32) : ch;
		System.out.println("ch : "+ch);
		System.out.println("ch to lowerCase : "+lowerCase);
		}
	
}
