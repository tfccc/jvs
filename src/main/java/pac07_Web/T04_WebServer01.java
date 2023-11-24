package pac07_Web;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TFC
 * @date   2019年8月1日 下午12:36:50
 * @note   手写web服务器01(基础版)
 * 
 * (使用ServerSocket建立与浏览器的连接，获取请求协议)
 * 
 */
public class T04_WebServer01 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		T04_WebServer01 server=new T04_WebServer01();
		server.start();
		
		server.stop();
	}
	//1.启动服务
	void start() {
		try {
			serverSocket=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("服务器启动失败...");
		}
	}
	//2.接收连接处理
	void receive() {
		try {
			Socket client=serverSocket.accept();
			System.out.println("建立了一个连接");
			//获取请求协议
			InputStream is=client.getInputStream();
			byte []data=new byte[1024*1024];
			int len=-1;
			while((len=is.read(data))!=-1) {
				System.out.println("\n请求协议内容：\n"+new String(data,0,len));
				System.out.println(data.length);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("建立连接失败...");
		}
	}
	//3.关闭服务
	void stop() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("关闭连接失败...");
		}
	}
}
