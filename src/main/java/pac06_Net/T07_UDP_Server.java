package pac06_Net;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import org.apache.commons.io.FileUtils;

/**
 * @author TFC
 * @date   2019年7月21日 下午5:30:50
 * @note   UDP测试(模拟接收/服务端)
 * 
 * 接收端
 * 1.使用DatagramSocket指定端口，创建接收端
 * 2.准备容器  封装为DatagramPacket的数组包裹
 * 3.阻塞式(类死循环)接收包裹receive()
 * 4.分析、操作数据
 * 5.释放资源(关闭端口)
 * 
 */
public class T07_UDP_Server {
	public static void main(String[] args) throws Exception {
		System.out.println("服务器启动中...");
		//1
		DatagramSocket server=new DatagramSocket(6667);
		//2
		byte[] container =new byte[1024*1024];
		DatagramPacket pac=new DatagramPacket(container, 0,
				container.length);
		//3
		server.receive(pac);
		//4
		byte[] data =pac.getData();
		//int len=pac.getLength();
		
		FileUtils.writeByteArrayToFile(new File("ball2222.png"), data);
		/*String str=new String(data, 0, len);
		System.out.println("接收数据:"+str);*/
		//5
		server.close();
		
	}
}
