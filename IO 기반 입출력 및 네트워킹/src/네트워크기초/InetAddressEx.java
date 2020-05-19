package 네트워크기초;

import java.net.InetAddress;

public class InetAddressEx {

	public static void main(String[] args) throws Exception {
		
		// IP 주소 얻기
		
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("내 컴퓨터의 IP 주소 : " + local.getHostAddress());
		
		InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
		for (InetAddress remote : iaArr) {
			System.out.println("www.naver.com 의 IP 주소 : " + remote.getHostAddress());
		}
		
	}
	
}

/* 결과
내 컴퓨터의 IP 주소 : 192.168.0.85
www.naver.com 의 IP 주소 : 125.209.222.141
www.naver.com 의 IP 주소 : 125.209.222.142
*/
