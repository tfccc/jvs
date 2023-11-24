package pac06_Net;

import java.net.InetSocketAddress;

/**
 * @author TFC
 * @date 2019年7月21日 上午9:50:05
 * @note 端口:设备/软件，与外界通讯交流的出口
 */
public class T02_Port {
    public static void main(String[] args) {
        //获取ip下的端口对象
        InetSocketAddress sa =
                new InetSocketAddress("192.168.31.229", 8080);
        System.out.println(sa.getPort());

    }
}
