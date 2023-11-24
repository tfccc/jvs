package pac06_Net;

import utils.IOStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

/**
 * @author TFC
 * @date   2019年7月24日 下午1:59:48
 * @note   本地聊天室01
 */
public class T09_TalkServer01 {
	public static void main(String[] args) throws Exception {
		System.out.println("客户端1");
		new Thread(new Send(8848, 8849)).start();
		new Thread(new Receive(8850,"用户1")).start();
	}
}


//封装的发送、接收线程方法
class Send implements Runnable{
	DatagramSocket client;
	DatagramPacket packet;
	int clientPort;
	int pacPort;
	
	Send(int clientPort, int pacPort) {
		this.clientPort=clientPort;
		this.pacPort   =pacPort;
	}
	@Override
	public void run() {
		Scanner sc=new Scanner(System.in);
		
		try {
			client = new DatagramSocket(clientPort);
			while(true) {
				String words=sc.next();
				if(words.equals("quit")) break;
				
				byte []data=words.getBytes();
				packet=new DatagramPacket(data, 0,data.length,
						new InetSocketAddress("localhost",pacPort)); 

				client.send(packet);
			}
		} catch (IOException e) { e.printStackTrace(); }

		sc.close();
		client.close();
	}
	
}
class Receive implements Runnable{
	DatagramSocket client;
	DatagramPacket packet;
	int clientPort;
	String name;
	
	Receive(int clientPort, String name) {
		this.clientPort = clientPort;
		this.name=name;
	}

	@Override
	public void run() {

		DatagramSocket server = null;
		
		try {
			server = new DatagramSocket(clientPort);
			while(true) {
				byte[] container =new byte[1024];
				DatagramPacket pac=new DatagramPacket(container, 0,
					container.length);
				server.receive(pac);
				byte[] data =pac.getData();
				String words=new String(data,0,data.length);
				if(words.equals("quit")) break;
				System.out.println(words);
				words="";
			}
		} catch (IOException e) { e.printStackTrace(); }

		IOStream.close(server);
	}
	
}