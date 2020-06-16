package Ch03;

public class Ch03_9 {

	// ch가 영문자이거나 숫자일 경우에만 b의 값이 true가 되게 하는 코드
	public static void main(String[] args) {
		char ch = 'z';
		boolean b = ( (ch>='a' && ch<='z') || (ch>='A' && ch<='Z') || (ch>='0' && ch<='9') ? true : false );
		System.out.println(b);
	}

}
