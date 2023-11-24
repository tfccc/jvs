package pac06_Net;

import java.io.File;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import org.apache.commons.io.FileUtils;

/**
 * @author TFC
 * @date   2019��7��21�� ����5:30:30
 * @note   UDP����(ģ��ͻ���)
 * 
 * 1.ʹ��DatagramSocketָ���˿ڣ��������Ͷ�
 * 2.׼������(�ֽ�����)
 * 3.��װDatagramSocket������ָ������Ŀ�ĵ�
 * 4.���Ͱ���send()
 * 5.�ͷ���Դ
 */
public class T06_UDP_Client {
	public static void main(String[] args) throws Exception {
		System.out.println("��ʼ��������...");
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
		System.out.println("���ݷ��ͳɹ�...");
		//5
		client.close();
	}
}
