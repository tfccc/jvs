package pac06_Net;

import java.net.InetSocketAddress;

/**
 * @author TFC
 * @date 2019��7��21�� ����9:50:05
 * @note �˿�:�豸/����������ͨѶ�����ĳ���
 */
public class T02_Port {
    public static void main(String[] args) {
        //��ȡip�µĶ˿ڶ���
        InetSocketAddress sa =
                new InetSocketAddress("192.168.31.229", 8080);
        System.out.println(sa.getPort());

    }
}
