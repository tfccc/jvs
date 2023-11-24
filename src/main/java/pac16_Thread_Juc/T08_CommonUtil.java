package pac16_Thread_Juc;

import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-22 10:34
 * @desc: juc???ù?????
 *
 * 1.CountDownLatch(?????????): ??????????
 *      (1)countDown(): ????-1
 *      (2)await(): ???, ???count??????????
 *
 * 2.CyclicBarrier(????????): ?????????
 *      (1)await(): ????????
 *
 * 3.Semaphore(?????/????): ????????????????
 *      (1)acquire(): ????????, ?????-1
 *      (2)release(): ???????????, ?????+1, ???????????
 *
 **/
public class T08_CommonUtil {

    private static int num1 = 100;
    private static int num2 = 10;
    private static int num3 = 6;
    private static Random random = new Random();

    @Test
    @DisplayName("1.CountDownLatch")
    public void test1() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(num1);
        for (int i = 0; i < num1; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is done");
                latch.countDown();
            }, i + "").start();
        }
        // ??count??????????????
        latch.await();
        System.out.println("all done..............");
        TimeUnit.MILLISECONDS.sleep(500);
    }


    @Test
    @DisplayName("2.CyclicBarrier")
    public void test2() throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(
                num2,
                () -> System.out.println(num2 + " thread is done...........")
        );
        for (int i = 0; i < num2; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " is done");
                try {
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, i + "").start();
        }
        TimeUnit.MILLISECONDS.sleep(500);
    }


    @Test
    @SneakyThrows
    @DisplayName("3.Semaphore")
    public void test3() {
        //???????3????λ
        Semaphore semaphore = new Semaphore(3);
        //???λ??
        Queue<Integer> parkingSpace = new ConcurrentLinkedDeque<>();
        for (int i = 1; i <= 3; i++) {
            parkingSpace.add(i);
        }

        for (int i = 1; i <= num3; i++) {
            new Thread(() -> {
                try {
                    //????????, ?????-1
                    semaphore.acquire();
                    Integer parkingSpaceNum = parkingSpace.poll();
                    System.out.println(Thread.currentThread().getName() +
                            "-->???-->" + parkingSpaceNum);
                    int parkingTime = random.nextInt(500) + 1000;

                    TimeUnit.MILLISECONDS.sleep(parkingTime);

                    System.out.println(Thread.currentThread().getName() +
                            "-->??-->" + parkingSpaceNum + " (???" + parkingTime + "ms)");
                    parkingSpace.add(parkingSpaceNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //???????????, ?????+1, ???????????
                    semaphore.release();
                }
            }, "car" + i).start();
        }
        TimeUnit.MILLISECONDS.sleep(1500 * num3);
    }

}
