package pac06_Net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * @author TFC
 * @date   2019��7��25�� ����1:34:43
 * @note   TCP������(�ͻ���)
 * 
 * 1.�������ӣ�ʹ��Socket�����ͻ���+����Ķ˿ں͵�ַ
 * 2.�������ݣ�IO��
 * 3.�ͷ���Դ
 * 
 */
public class T11_TCP_Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		System.out.println("�ͻ��˿���");
		//1
		Socket client =new Socket("localhost",8888);
		//2
		DataOutputStream out=new DataOutputStream(client.getOutputStream());

		String s;
		while (true) {
			s = new Scanner(System.in).next();
			if (s.equals("0")){
				out.writeUTF("�ͻ��������Ͽ�����");
				out.flush();
			    break;
			}
			out.writeUTF(s);
			out.flush();
		}

		client.close();
	}
}
