package pac06_Net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TFC
 * @date   2019年7月25日 下午2:12:07
 * @note   TCP模拟接收登陆信息  并返回值
 */
public class T14_TCP_LoginServer {

	public static void main(String[] args) throws IOException {
		System.out.println("服务器开启");
		//1
		ServerSocket server=new ServerSocket(8888);
		//2
		Socket client=server.accept();
		System.out.println("客户端已连接...");
		//3
		DataInputStream in=new DataInputStream(client.getInputStream());
		String []userinfo=in.readUTF().split("/");
		String userName=userinfo[0];
		String passWord=userinfo[1];
		System.out.println("接收到账号:"+userName);
		System.out.println("接收到密码:"+passWord);
		
		//判断，返回给客户端值
		DataOutputStream out=new DataOutputStream(client.getOutputStream());
		if(userName.equals("user01")&&passWord.equals("123456")) {
			out.writeUTF("账号密码正确，登陆成功！");
		}else {
			out.writeUTF("账号密码错误，登陆失败！");
		}
		//4
		server.close();
	}
}
