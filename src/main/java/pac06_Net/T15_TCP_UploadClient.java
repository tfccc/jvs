package pac06_Net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import utils.IOStream;

/**
 * @author TFC
 * @date   2019年7月25日 下午2:26:44
 * @note   上传文件
 */
public class T15_TCP_UploadClient {

	public static void main(String[] args) throws IOException {
		System.out.println("客户端开启");
		//1
		Socket client =new Socket("localhost",8888);
		//2
		File file=new File("img/ball.png");
		InputStream in=new BufferedInputStream(
				new FileInputStream(file));
		OutputStream out=new BufferedOutputStream(
				client.getOutputStream());
		byte[] buffer =new byte[1024];
		int len;
		while((len=in.read(buffer))!=-1) {
			out.write(buffer,0,len);
		}
		out.flush();
		System.out.println("文件发送成功...");
		//3
		IOStream.close(out,in,client);
	}

}
