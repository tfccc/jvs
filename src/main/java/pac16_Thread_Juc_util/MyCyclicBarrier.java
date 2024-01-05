package pac16_Thread_Juc_util;

import java.util.Random;
import java.util.concurrent.*;

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
        CyclicBarrier barrier = new CyclicBarrier(
                3,
                () -> System.out.println("a batch of thread reach barrier...........")
        );

        for (int i = 1; i <= 5; i++) {
            String threadName = "Ïß³Ì" + i;
            int finalI = i;
            new Thread(() -> {
                try {
                    TimeUnit.SECONDS.sleep(finalI);
                    barrier.await(8, TimeUnit.SECONDS);
                    System.out.println(Thread.currentThread().getName() + " DONE");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    System.out.println("barrier is broken");
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    System.out.println("barrier timeout");
                    throw new RuntimeException(e);
                }
            }, threadName).start();
        }


        System.out.println("reach end");
        //barrier.reset();
    }


}
