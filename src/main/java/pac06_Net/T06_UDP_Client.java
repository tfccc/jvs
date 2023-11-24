package pac06_Net;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import org.apache.commons.io.FileUtils;

/**
 * @author TFC
 * @date   2019年7月21日 下午5:30:30
 * @note   UDP测试(模拟客户端)
 * 
 * 1.使用DatagramSocket指定端口，创建发送端
 * 2.准备数据(字节数组)
 * 3.封装DatagramSocket包裹，指包裹定目的地
 * 4.发送包裹send()
 * 5.释放资源
 */
public class T06_UDP_Client {
	public static void main(String[] args) throws Exception {
		System.out.println("开始发送数据...");
		//1
		DatagramSocket client=new DatagramSocket(9999);
		//2
		File file=new File("ball.png");

		byte[] pack =FileUtils.readFileToByteArray(file);
		//3
		DatagramPacket packet=new DatagramPacket(pack, 0,pack.length,
				new InetSocketAddress("localhost",6667)); 
		//4
		client.send(packet);
		System.out.println("数据发送成功...");
		//5
		client.close();
	}
}
