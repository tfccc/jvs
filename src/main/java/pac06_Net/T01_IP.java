package pac06_Net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author TFC
 * @date   2019��7��19�� ����2:42:37
 * @note   ip:���ڶ�λ�ڵ�(�������·�������ƶ��豸��)
 */
public class T01_IP {
	public static void main(String[] args) throws UnknownHostException {
		//�õ������������
		InetAddress address=InetAddress.getLocalHost();
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());
		System.out.println("---------------");
		
		
		//���������õ��������
		address=InetAddress.getByName("www.baidu.com");
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
		System.out.println("---------------");
		
		
		//����ip�õ��������
		address=InetAddress.getByName("192.168.31.229");
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
	}
}
