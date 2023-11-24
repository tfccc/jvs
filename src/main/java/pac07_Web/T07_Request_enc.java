package pac07_Web;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 * @author TFC
 * @date   2019��8��3�� ����11:09:26
 * @note   ��װrequest(��װ������Ϣ(method,src,�������))
 */
public class T07_Request_enc {
	private String requestInfo;
	private String method;		//����ʽ
	private String src;			//����src
	private String parameter;	//�������
	
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
		//1.��ȡmethod
		method=requestInfo.substring(
				0,requestInfo.indexOf("/"))/*.toLowerCase()*/.trim();
		//2.��ȡsrc
		//(a)��ȡ/��λ��
		int start=requestInfo.indexOf("/")+1;
		//(b)��ȡhttp/��λ��
		int  end =requestInfo.indexOf("HTTP/");
		//(c)�ָ��ַ���
		src=requestInfo.substring(start,end);
		//(d)��ȡ?��λ��
		int queMark=requestInfo.indexOf("?");
		//(e)�ָ��ʺ����ҵ��ַ�
		if(queMark>=0/*�����������*/) {
			String[] urlArray=src.split("\\?");
			src=urlArray[0];
			parameter=urlArray[1];
		}
		//3.��ȡ�������
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
		
		System.out.println(method+"����>"+src+"����>"+parameter+"\n");
	}
}
