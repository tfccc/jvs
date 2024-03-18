package pac16_Thread_Juc_util;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @author Frank.Tang
 * @date 2024-03-18 11:19
 * @desc 模拟匹配
 **/
public class CyclicBarrierForRankMatchSimulate {

    private static final CyclicBarrierOverwrite BARRIER = new CyclicBarrierOverwrite(
            5,
            () -> {
                System.out.print("5个玩家已就位. ");
            }
    );

    public static void main(String[] args) {

        // 100个玩家
        for (int i = 1; i <= 45; i++) {
            int finalI = i;
            new Thread(() -> {
                String name = Thread.currentThread().getName();
                try {
                    TimeUnit.SECONDS.sleep(finalI % 3 + 1);

                    BARRIER.await(5, TimeUnit.SECONDS, name);

                } catch (InterruptedException e) {
                    System.out.println(name + " interrupted");
                    throw new RuntimeException(e);
                } catch (BrokenBarrierException | TimeoutException e) {
                    System.out.println(name + " 匹配超时");
                    throw new RuntimeException(e);
                }
            }, "player" + i).start();
        }

        System.out.println("所有玩家已加入匹配池");

    }

}
