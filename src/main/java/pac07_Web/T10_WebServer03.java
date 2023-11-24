package pac07_Web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TFC
 * @date 2019年8月5日 上午10:10:27
 * @note 手写web服务器02(进阶版)
 *
 * 	1.(将t05接入Servlet接口)
 * 	2.(加入servlet解耦了业务代码(引入html文件))
 * 	3.(加入多线程)
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

    //1.启动服务
    public void start() throws IOException {
        serverSocket = new ServerSocket(8888);
        running = true;
        receive();
    }

    //2.接收连接处理
    public void receive() {
        while (running) {
            try {
                client = serverSocket.accept();
                System.out.println("建立了一个连接:" + count);
				/*//1.得到请求协议
				req=new T08_Request_enc2(client);
				//2.返回响应协议,和请求内容
				res=new T06_Response_enc(client);
				//html文档用servlet接口在T06的外部实现，内部只关注responseInfo
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

    //3.关闭服务
    public void stop() {
        try {
            running = false;
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
