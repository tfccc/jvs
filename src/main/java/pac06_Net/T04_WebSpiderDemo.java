package pac06_Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author TFC
 * @date   2019年7月21日 上午10:18:00
 * @note   网络爬虫简单样例
 */
public class T04_WebSpiderDemo {
	public static void main(String[] args) throws IOException {
		//webSpider01();
		webSpider02();
	}
	
	//爬取网页内容
	static void webSpider01() throws IOException {
		URL url=new URL("https://www.dianping.com");
		InputStream in=url.openStream();
		InputStreamReader isr=new InputStreamReader(in,"gbk");
		BufferedReader     br=new BufferedReader(isr);
		
		String data=null;
		while((data=br.readLine())!=null) {
			System.out.println(data);
		}
	}
	
	//模拟浏览器(爬取“不能直接爬取”的资源)
	static void webSpider02() throws IOException{
		URL url=new URL("https://www.dianping.com");
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		//请求方式+请求属性(模拟浏览器访问请求)
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.108 Safari/537.36");
		
		InputStreamReader isr=new InputStreamReader(con.getInputStream(),"gbk");
		BufferedReader     br=new BufferedReader(isr);
		String data=null;
		while((data=br.readLine())!=null) {
			System.out.println(data);
		}
	}
	
}
