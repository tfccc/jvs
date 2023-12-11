package pac05_Thread;

import java.util.concurrent.TimeUnit;

/**
 * @author TFC
 * @date 2019��7��17�� ����12:04:32
 * @note �ػ��߳�
 *
 * 1.�߳�Ĭ�����û��߳�
 * 2.jvm���û��߳�ִ�����ֹͣ
 *
 */
public class T15_Daemon {

    public static void main(String[] args) {
        //�û��߳�
        Thread t1 = new Thread(() -> {
            for (int i = 1; i <= 20; i++) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("main:" + i);
            }
        });
        //�ػ��߳�
        Thread t2 = new Thread(() -> {
            int i = 0;
            while (true) {
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("daemon:" + (++i));
            }
        });
        //�����ػ��߳�
        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}
