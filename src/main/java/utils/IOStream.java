package utils;

import java.io.Closeable;

/**
 * @author TFC
 * @date 2019��7��9�� ����7:44:39
 * @note IO���رչ���
 */
public class IOStream {

    /**
     * @Desc �ر�IO��
     * @param streams:�ɱ�����,�ɴ���������������һ��������
     * @return void
     */
    public static void close(Closeable... streams) {
        for (Closeable stream : streams) {
            try {
                if (null != stream) stream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}