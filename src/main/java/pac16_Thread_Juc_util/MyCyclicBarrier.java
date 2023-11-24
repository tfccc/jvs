package pac16_Thread_Juc_util;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author Frank.Tang
 * @date 2023-03-28 13:33
 * @desc
 **/
public class MyCyclicBarrier {

    private static final Random RANDOM = new Random();


    public static void main(String[] args) {
        demo1();
    }


    /**
     *
     * @author Frank.Tang
     */
    private static void demo1() {
        CyclicBarrier barrier = new CyclicBarrier(3);

        for (int i = 1; i <= 5; i++) {
            String threadName = "œﬂ≥Ã" + i;
            new Thread(() -> {
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    System.out.println("∆¡’œ±ªÕª∆∆");
                    e.printStackTrace();
                }
            }, threadName).start();
        }
        barrier.reset();
    }


}
