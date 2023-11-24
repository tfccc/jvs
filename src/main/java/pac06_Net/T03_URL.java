package pac06_Net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author TFC
 * @date   2019��7��21�� ����10:04:38
 * @note   URL(ͳһ��Դ��λ��)
 *  
 *  ��ɣ�
 *  1.Э��		(http\ftp...)
 *  2.����/ip	(www.baidu.com)
 *  3.�˿�		(8080)
 *  4.������Դ	(html��������ê���)
 */
public class T03_URL {
	public static void main(String[] args) throws MalformedURLException {
		getURL();
	}
	
	private static void getURL() throws MalformedURLException {
		URL url=new URL("https://www.bilibili.com/video/av30023103/?p=237");
		System.out.println(url.getProtocol());
		System.out.println(url.getHost());
		System.out.println(url.getPort());
		System.out.println(url.getPath());
		System.out.println(url.getQuery());
	}
	
}
