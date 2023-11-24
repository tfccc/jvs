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
     * 使用CountDownLatch, 模拟线程达到一定数量后, 再开锁进入下面的代码
     * @author Frank.Tang
     */
    private static void demo1() {
        CountDownLatch latch = new CountDownLatch(3);

        for (int i = 1; i <= 5; i++) {
            String threadName = "线程" + i;
            new Thread(() -> {
                //模拟线程执行时间
                int waitTime = RANDOM.nextInt(1001) + 4000;

                try {
                    TimeUnit.MILLISECONDS.sleep(waitTime);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                latch.countDown();
                System.out.println(threadName + ", 执行完毕, 门锁量递减");
            }, threadName).start();
        }

        //阻塞, 等待达到开锁量
        try {
            System.out.println("latch进入阻塞状态");
            latch.await();
            System.out.println("latch解除阻塞状态");
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
