package pac06_Net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author TFC
 * @date   2019年7月25日 下午2:11:44
 * @note   TCP模拟登陆
 */
public class T13_TCP_LoginClient {
	static String userName[]= {"user01","user02","user03","user04"};
	static String passWord[]= {"123456","111","222","333"};
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端开启");
		//1
		Socket client =new Socket("localhost",8888);
		//2
		for(int i=0;i<4;i++) {
		DataOutputStream out=new DataOutputStream(client.getOutputStream());
		
			out.writeUTF(userName[i]+"/"+passWord[i]);
			out.flush();
			System.out.println("数据已发送...");
		
		
		//接收返回值
		DataInputStream in=new DataInputStream(client.getInputStream());
		String result=in.readUTF();
		System.out.println(result);}
		//3
		client.close();
	}
}
