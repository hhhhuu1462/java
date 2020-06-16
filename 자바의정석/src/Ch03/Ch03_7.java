package Ch03;

public class Ch03_7 {

	// È­¾¾¸¦ ¼·¾¾·Î º¯È¯ÇÏ´Â ÄÚµå
	//  º¯È¯°ø½Ä : 'C =	5/9 ¡¿(F - 32)'
	public static void main(String[] args) {
		int fahrenheit = 100; // È­¾¾
		float celcius = (int) ((5 / 9f * (fahrenheit - 32)) * 100 + 0.5) / 100f ; // ¼·¾¾
		System.out.println("Fahrenheit:"+fahrenheit);
		System.out.println("Celcius:"+celcius);
	}

}
