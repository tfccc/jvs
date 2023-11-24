package pac06_Net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author TFC
 * @date   2019年7月25日 下午1:34:43
 * @note   TCP网络编程(客户端)
 * 
 * 1.建立连接：使用Socket创建客户端+服务的端口和地址
 * 2.操作数据：IO流
 * 3.释放资源
 * 
 */
public class T11_TCP_Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("客户端开启");
		//1
		Socket client =new Socket("localhost",8888);
		//2
		DataOutputStream out=new DataOutputStream(client.getOutputStream());

		String s;
		while (true) {
			s = new Scanner(System.in).next();
			if (s.equals("0")){
				out.writeUTF("客户端主动断开连接");
				out.flush();
			    break;
			}
			out.writeUTF(s);
			out.flush();
		}

		client.close();
	}
}
