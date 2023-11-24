package pac06_Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TFC
 * @date 2019��7��25�� ����1:38:29
 * @note TCP������(�����)
 *
 * 1.ָ���˿� ʹ��ServerSocket����������
 * 2.����ʽ�ȴ�����
 * 3.�������ݣ�IO��
 * 4.�ͷ���Դ
 *
 */
public class T12_TCP_Server {
    public static void main(String[] args) throws IOException {
        System.out.println("����������");
        //1
        ServerSocket server = new ServerSocket(8888);
        //2
        Socket client;
        client = server.accept();
        System.out.println("�ͻ���������...");
        while (true) {
            //3
            DataInputStream in = new DataInputStream(client.getInputStream());
            String data = in.readUTF();
            if (data.equals("�ͻ��������Ͽ�����")){
                System.out.println(data);
                break;
            }
            System.out.println(data);
        }
        //4
        server.close();
    }
}
