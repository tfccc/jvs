package pac00_Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
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
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                2,
                2,
                1,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(2),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        long am = 1000 * 5;
        long sTime = System.currentTimeMillis();
        Runnable r1 = () -> {
            while (System.currentTimeMillis() - sTime <= am) {
                mt.incrementAndGet();
            }
            latch0.countDown();
        };
        for (int i = 1; i <= THREAD_NUM; i++) {
            pool.execute(r1);
        }
        try {
            latch0.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Runnable r2= () -> {
            while (System.currentTimeMillis() - sTime <= am) {
                mt.incrementAndGet();
            }
            latch1.countDown();
        };
        for (int i = 1; i <= THREAD_NUM; i++) {
            pool.execute(r2);
        }

        try {
            latch1.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(mt.longValue());

        pool.shutdown();
    }

}
