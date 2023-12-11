package pac00_Test;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Frank.Tang
 * @date 2023-03-25 14:28
 * @desc
 **/
public class Testtttt {


    private static AtomicLong main = new AtomicLong(0);
    private static AtomicLong mt = new AtomicLong(0);

    private static final int THREAD_NUM = 4;
    private static CountDownLatch latch1 = new CountDownLatch(THREAD_NUM);
    private static CountDownLatch latch0 = new CountDownLatch(THREAD_NUM);


    public static void main(String[] args) {
        new Thread(() -> {
            for (; ; ) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test();
            }
        }).start();
        new Thread(() -> {
            for (; ; ) {
                try {
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                test();
            }
        }).start();

        try {
            TimeUnit.MILLISECONDS.sleep(1000 * 2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static String lock = "1";

    private static void test() {
        synchronized (lock) {
            System.out.println(lock);
        }
    }


}
