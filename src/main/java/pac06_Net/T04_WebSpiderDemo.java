package pac06_Net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author TFC
 * @date   2019��7��21�� ����10:18:00
 * @note   �������������
 */
public class T04_WebSpiderDemo {
	public static void main(String[] args) throws IOException {
		//webSpider01();
		webSpider02();
	}
	
	//��ȡ��ҳ����
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
	
	//ģ�������(��ȡ������ֱ����ȡ������Դ)
	static void webSpider02() throws IOException{
		URL url=new URL("https://www.dianping.com");
		HttpURLConnection con=(HttpURLConnection)url.openConnection();
		//����ʽ+��������(ģ���������������)
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
