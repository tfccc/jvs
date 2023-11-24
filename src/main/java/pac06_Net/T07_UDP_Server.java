package pac06_Net;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import org.apache.commons.io.FileUtils;

/**
 * @author TFC
 * @date   2019��7��21�� ����5:30:50
 * @note   UDP����(ģ�����/�����)
 * 
 * ���ն�
 * 1.ʹ��DatagramSocketָ���˿ڣ��������ն�
 * 2.׼������  ��װΪDatagramPacket���������
 * 3.����ʽ(����ѭ��)���հ���receive()
 * 4.��������������
 * 5.�ͷ���Դ(�رն˿�)
 * 
 */
public class T07_UDP_Server {
	public static void main(String[] args) throws Exception {
		System.out.println("������������...");
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
		System.out.println("��������:"+str);*/
		//5
		server.close();
		
	}
}
