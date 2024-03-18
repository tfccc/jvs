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


    private static final CyclicBarrier BARRIER = new CyclicBarrier(
            3,
            () -> {
                System.out.println("a batch of thread reach barrier...........");
            }
    );

    /**
     *
     * @author Frank.Tang
     */
    private static void demo1() {

        for (int i = 1; i <= 10; i++) {
            String threadName = "Ïß³Ì" + i;
            int finalI = i;
            new Thread(() -> {
                try {
                    //TimeUnit.SECONDS.sleep(finalI);
                    BARRIER.await(5, TimeUnit.SECONDS);
                    //BARRIER.await();
                    System.out.println(Thread.currentThread().getName() + " DONE");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    System.out.println("barrier is broken");
                    e.printStackTrace();
                }/* catch (TimeoutException e) {
                    System.out.println("barrier wait timeout");
                    throw new RuntimeException(e);
                }*/ catch (TimeoutException e) {
                    System.out.println(Thread.currentThread().getName() + " await timeout");
                    throw new RuntimeException(e);
                }
            }, threadName).start();
        }
        if (BARRIER.isBroken()) {
            System.out.println("is broken");
            BARRIER.reset();
            System.out.println("reset success");
        } else {
            System.out.println("not broken");
        }

        System.out.println("reach end");
        //barrier.reset();
    }


}
