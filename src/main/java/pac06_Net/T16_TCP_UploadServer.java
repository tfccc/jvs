package pac06_Net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import utils.IOStream;

/**
 * @author TFC
 * @date   2019年7月25日 下午2:32:51
 * @note   接收文件
 */
public class T16_TCP_UploadServer {
	public static void main(String[] args) throws IOException {
		System.out.println("客户端开启");
		//1
		ServerSocket server =new ServerSocket(8888);
		//2
		Socket client=server.accept();
		InputStream in=new BufferedInputStream(
				client.getInputStream());
		OutputStream out=new BufferedOutputStream(
				new FileOutputStream("ball2.png"));
		byte[] buffer =new byte[1024];
		int len=-1;
		while((len=in.read(buffer))!=-1) {
			out.write(buffer,0,len);
		}
		out.flush();
		System.out.println("接收到客户端文件...");
		//3
		IOStream.close(out,in,server);
		
	}
}
