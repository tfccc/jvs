package pac06_Net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author TFC
 * @date   2019年7月21日 上午10:04:38
 * @note   URL(统一资源定位符)
 *  
 *  组成：
 *  1.协议		(http\ftp...)
 *  2.域名/ip	(www.baidu.com)
 *  3.端口		(8080)
 *  4.请求资源	(html、参数、锚点等)
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
