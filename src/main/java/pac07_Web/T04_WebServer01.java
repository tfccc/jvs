package pac07_Web;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TFC
 * @date   2019��8��1�� ����12:36:50
 * @note   ��дweb������01(������)
 * 
 * (ʹ��ServerSocket����������������ӣ���ȡ����Э��)
 * 
 */
public class T04_WebServer01 {
	private ServerSocket serverSocket;
	public static void main(String[] args) {
		T04_WebServer01 server=new T04_WebServer01();
		server.start();
		
		server.stop();
	}
	//1.��������
	void start() {
		try {
			serverSocket=new ServerSocket(8888);
			receive();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("����������ʧ��...");
		}
	}
	//2.�������Ӵ���
	void receive() {
		try {
			Socket client=serverSocket.accept();
			System.out.println("������һ������");
			//��ȡ����Э��
			InputStream is=client.getInputStream();
			byte []data=new byte[1024*1024];
			int len=-1;
			while((len=is.read(data))!=-1) {
				System.out.println("\n����Э�����ݣ�\n"+new String(data,0,len));
				System.out.println(data.length);
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("��������ʧ��...");
		}
	}
	//3.�رշ���
	void stop() {
		try {
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("�ر�����ʧ��...");
		}
	}
}
