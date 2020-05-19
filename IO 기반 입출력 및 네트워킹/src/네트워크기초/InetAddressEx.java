package ��Ʈ��ũ����;

import java.net.InetAddress;

public class InetAddressEx {

	public static void main(String[] args) throws Exception {
		
		// IP �ּ� ���
		
		InetAddress local = InetAddress.getLocalHost();
		System.out.println("�� ��ǻ���� IP �ּ� : " + local.getHostAddress());
		
		InetAddress[] iaArr = InetAddress.getAllByName("www.naver.com");
		for (InetAddress remote : iaArr) {
			System.out.println("www.naver.com �� IP �ּ� : " + remote.getHostAddress());
		}
		
	}
	
}

/* ���
�� ��ǻ���� IP �ּ� : 192.168.0.85
www.naver.com �� IP �ּ� : 125.209.222.141
www.naver.com �� IP �ּ� : 125.209.222.142
*/