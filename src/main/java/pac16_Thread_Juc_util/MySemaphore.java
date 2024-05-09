package pac16_Thread_Juc_util;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Frank.Tang
 * @date 2023-03-28 11:35
 * @desc 信号量实战
 **/
public class MySemaphore {

    private static final Random RANDOM = new Random();


    public static void main(String[] args) {
        //parkingLotDemo1();
        //parkingLotDemo2();

        try {
            System.out.println("try");
            System.exit(1);
            Runtime.getRuntime().exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }


    /**
     * 使用Semaphore模拟停车场停车过程 (一车一位)
     * @author Frank.Tang
     */
    private static void parkingLotDemo1() {
        //停车场, 拥有n个停车位
        Semaphore semaphore = new Semaphore(4);

        //n个车, 想要进去停车
        for (int i = 1; i <= 10; i++) {
            final String carName = "car" + i;

            //停车时间
            int parkTime = RANDOM.nextInt(1001) + 5000;

            new Thread(() -> {
                try {
                    //申请车位
                    System.out.println(carName + "--申请车位");
                    semaphore.acquire();

                    //开始停车
                    System.out.println(carName + "--开始停车, 停车时间=" + parkTime);
                    TimeUnit.MILLISECONDS.sleep(parkTime);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //停车结束
                    semaphore.release();
                    System.out.println(carName + "--停车结束");
                }
            }, carName).start();
        }
    }

    /**
     * 使用Semaphore模拟停车场停车过程 (一车多位)
     * @author Frank.Tang
     */
    private static void parkingLotDemo2() {
        //停车场, 拥有十个停车位
        Semaphore semaphore = new Semaphore(5);

        //一车占多个车位, 一次获取n个型号量/一次释放n个信号量
        int carSize = 2;

        //20个车, 想要进去停车
        for (int i = 1; i <= 10; i++) {
            final String carName = "car" + i;

            //停车时间
            int parkTime = RANDOM.nextInt(1001) + 5000;

            new Thread(() -> {
                //停车
                try {
                    //申请车位
                    System.out.println(carName + "--申请车位");

                    boolean acquireSuccess = semaphore.tryAcquire(carSize, 3000, TimeUnit.MILLISECONDS);

                    //等一段时间还没车位
                    if (!acquireSuccess) {
                        throw new RuntimeException();
                    }

                    //开始停车
                    System.out.println(carName + "--开始停车, 停车时间=" + parkTime);
                    TimeUnit.MILLISECONDS.sleep(parkTime);

                    //停车结束
                    semaphore.release(carSize);
                    System.out.println(carName + "--停车结束");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (RuntimeException e) {
                    System.out.println(carName + "--等待过久, 离开停车场");
                    e.printStackTrace();
                }
            }, carName).start();
        }

    }

}
