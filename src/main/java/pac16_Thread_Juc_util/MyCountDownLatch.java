package pac16_Thread_Juc_util;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Frank.Tang
 * @date 2023-03-28 13:06
 * @desc
 **/
public class MyCountDownLatch {

    private static final Random RANDOM = new Random();


    public static void main(String[] args) {
        demo1();
    }


    /**
     * ʹ��CountDownLatch, ģ���̴߳ﵽһ��������, �ٿ�����������Ĵ���
     * @author Frank.Tang
     */
    private static void demo1() {
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 1; i <= 5; i++) {
            String threadName = "�߳�" + i;
            new Thread(() -> {
                //ģ���߳�ִ��ʱ��
                int waitTime = RANDOM.nextInt(1001) + 4000;

                try {
                    TimeUnit.MILLISECONDS.sleep(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                latch.countDown();
                System.out.println(threadName + ", ִ�����, �������ݼ�");
            }, threadName).start();
        }

        //����, �ȴ��ﵽ������
        try {
            System.out.println("latch��������״̬");
            latch.await();
            System.out.println("latch�������״̬");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * CountDownLatch
     * @author Frank.Tang
     */
    private static void demo2() {

    }

}
