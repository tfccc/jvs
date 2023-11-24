package pac07_Web;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author TFC
 * @date   2019年8月3日 上午11:09:26
 * @note   封装request(封装请求信息(method,src,请求参数))
 */
public class T07_Request_enc {
	private String requestInfo;
	private String method;		//请求方式
	private String src;			//请求src
	private String parameter;	//请求参数
	
	public T07_Request_enc(InputStream in) throws IOException {
		byte []datas=new byte[1024*100];
		int len=in.read(datas);
		if(len>0)
			requestInfo=new String(datas,0,len);
	}
	
	public T07_Request_enc(Socket client) throws IOException {
		this(client.getInputStream());
	
	}
	public String getRequest() {
		return requestInfo;
	}
	
	public void parseRequest() {
		//1.获取method
		method=requestInfo.substring(
				0,requestInfo.indexOf("/"))/*.toLowerCase()*/.trim();
		//2.获取src
		//(a)获取/的位置
		int start=requestInfo.indexOf("/")+1;
		//(b)获取http/的位置
		int  end =requestInfo.indexOf("HTTP/");
		//(c)分割字符串
		src=requestInfo.substring(start,end);
		//(d)获取?的位置
		int queMark=requestInfo.indexOf("?");
		//(e)分割问号左右的字符
		if(queMark>=0/*存在请求参数*/) {
			String[] urlArray=src.split("\\?");
			src=urlArray[0];
			parameter=urlArray[1];
		}
		//3.获取请求参数
		if(method.equals("POST")) {
			String str=requestInfo.substring(
					requestInfo.lastIndexOf("\r\n")).trim();
			if(null==parameter){
				parameter=str; 
			}
			else{
				parameter+="&"+str; 
			}
		}
		parameter=(null==parameter?"":parameter);
		
		System.out.println(method+"——>"+src+"——>"+parameter+"\n");
	}
}
