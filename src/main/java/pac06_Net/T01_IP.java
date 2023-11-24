package pac06_Net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author TFC
 * @date   2019年7月19日 下午2:42:37
 * @note   ip:用于定位节点(计算机、路由器、移动设备等)
 */
public class T01_IP {
	public static void main(String[] args) throws UnknownHostException {
		//得到本机网络对象
		InetAddress address=InetAddress.getLocalHost();
		System.out.println(address.getHostName());
		System.out.println(address.getHostAddress());
		System.out.println("---------------");
		
		
		//根据域名得到网络对象
		address=InetAddress.getByName("www.baidu.com");
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
		System.out.println("---------------");
		
		
		//根据ip得到网络对象
		address=InetAddress.getByName("192.168.31.229");
		System.out.println(address.getHostAddress());
		System.out.println(address.getHostName());
	}
}
