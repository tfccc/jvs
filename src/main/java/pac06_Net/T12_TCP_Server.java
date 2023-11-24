package pac06_Net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author TFC
 * @date 2019年7月25日 下午1:38:29
 * @note TCP网络编程(服务端)
 *
 * 1.指定端口 使用ServerSocket创建服务器
 * 2.阻塞式等待连接
 * 3.操作数据：IO流
 * 4.释放资源
 *
 */
public class T12_TCP_Server {
    public static void main(String[] args) throws IOException {
        System.out.println("服务器开启");
        //1
        ServerSocket server = new ServerSocket(8888);
        //2
        Socket client;
        client = server.accept();
        System.out.println("客户端已连接...");
        while (true) {
            //3
            DataInputStream in = new DataInputStream(client.getInputStream());
            String data = in.readUTF();
            if (data.equals("客户端主动断开连接")){
                System.out.println(data);
                break;
            }
            System.out.println(data);
        }
        //4
        server.close();
    }
}
