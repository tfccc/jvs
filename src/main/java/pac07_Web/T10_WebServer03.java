package pac07_Web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TFC
 * @date 2019��8��5�� ����10:10:27
 * @note ��дweb������02(���װ�)
 *
 * 	1.(��t05����Servlet�ӿ�)
 * 	2.(����servlet������ҵ�����(����html�ļ�))
 * 	3.(������߳�)
 */
public class T10_WebServer03 {
    private ServerSocket serverSocket;
    private Socket client;
    private T06_Response_enc res;
    private T08_Request_enc2 req;
    private boolean running = false;
    private int count = 1;
    //private File html=new File("src/pac5_Web/index.html");

    public static void main(String[] args) throws IOException {
        T10_WebServer03 server = new T10_WebServer03();
        server.start();
        server.stop();
    }

    //1.��������
    public void start() throws IOException {
        serverSocket = new ServerSocket(8888);
        running = true;
        receive();
    }

    //2.�������Ӵ���
    public void receive() {
        while (running) {
            try {
                client = serverSocket.accept();
                System.out.println("������һ������:" + count);
				/*//1.�õ�����Э��
				req=new T08_Request_enc2(client);
				//2.������ӦЭ��,����������
				res=new T06_Response_enc(client);
				//html�ĵ���servlet�ӿ���T06���ⲿʵ�֣��ڲ�ֻ��עresponseInfo
				T09_Servlet servlet=new Servlet01();
				servlet.service(res, req);
				res.pushToBrowser(200);*/
                new Thread(new T11_Dispatcher(client)).start();
                count++;
            } catch (IOException e) {
                e.printStackTrace();
                stop();
            }
        }

    }

    //3.�رշ���
    public void stop() {
        try {
            running = false;
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
