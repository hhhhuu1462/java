package Ch03;

public class Ch03_10 {

	// 대문자를 소문자로 변경하는 코드
	// ch에 저장 된 문자가 대문자인 경우에만 소문자로 변경
	// 문자코드는 소문자가 대문자보다 32만큼 더 크다
	public static void main(String[] args) {
		char ch = 'A';
		char lowerCase = (ch >= 'A' && ch <= 'Z') ?  (char)(ch+32) : ch;
		System.out.println("ch : "+ch);
		System.out.println("ch to lowerCase : "+lowerCase);
		}
	
}
