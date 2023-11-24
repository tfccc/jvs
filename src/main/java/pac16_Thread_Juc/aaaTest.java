package pac16_Thread_Juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-10-15 17:54
 * @desc:
 **/
public class aaaTest {

    private static AtomicInteger n = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        long sTime = System.currentTimeMillis();
        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    n.incrementAndGet();
                }
            }).start();
        }

        TimeUnit.MILLISECONDS.sleep(100);
        System.out.println(n);
        long eTime = System.currentTimeMillis();
        System.out.println("ºÄÊ±: " + (eTime - sTime) + "ms");
    }

}
