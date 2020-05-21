package Chapter6;

public class Ex19 {

	public static void change(String str) {
		str += "456";
	}
	// change의 str은 ABC123456
	// 메인에서 참조하는 변수가 없기 때문에 자동 소멸 by garbage collector
	
	public static void main(String[] args) {
		
		String str = "ABC123";
		System.out.println(str);
		change(str);
		System.out.println("After change : "+str); // ABC123 그대로 출력

	}

}
