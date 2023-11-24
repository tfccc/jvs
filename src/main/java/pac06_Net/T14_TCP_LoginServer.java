package pac06_Net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TFC
 * @date   2019��7��25�� ����2:12:07
 * @note   TCPģ����յ�½��Ϣ  ������ֵ
 */
public class T14_TCP_LoginServer {

	public static void main(String[] args) throws IOException {
		System.out.println("����������");
		//1
		ServerSocket server=new ServerSocket(8888);
		//2
		Socket client=server.accept();
		System.out.println("�ͻ���������...");
		//3
		DataInputStream in=new DataInputStream(client.getInputStream());
		String []userinfo=in.readUTF().split("/");
		String userName=userinfo[0];
		String passWord=userinfo[1];
		System.out.println("���յ��˺�:"+userName);
		System.out.println("���յ�����:"+passWord);
		
		//�жϣ����ظ��ͻ���ֵ
		DataOutputStream out=new DataOutputStream(client.getOutputStream());
		if(userName.equals("user01")&&passWord.equals("123456")) {
			out.writeUTF("�˺�������ȷ����½�ɹ���");
		}else {
			out.writeUTF("�˺�������󣬵�½ʧ�ܣ�");
		}
		//4
		server.close();
	}
}
