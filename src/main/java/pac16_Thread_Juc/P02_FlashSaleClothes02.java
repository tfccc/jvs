package pac16_Thread_Juc;

import lombok.Data;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-22 14:59
 * @desc: Lock+Callable模拟商品抢购
 **/
public class P02_FlashSaleClothes02 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FlashSaleClothes2 sale = new FlashSaleClothes2(100);
        for (int i = 1; i <= 120; i++) {
            UserThread userThread = new UserThread(sale);
            FutureTask<Integer> task = new FutureTask<>(userThread);
            new Thread(task, "用户" + i).start();
            //get可能会产生阻塞(需放在最后, 或用异步通信)
            Object o = task.get();
            System.out.println(" --> return " + o);
        }

    }

}


class UserThread implements Callable<Integer> {
    FlashSaleClothes2 clothes;
    Lock lock = new ReentrantLock();

    public UserThread(FlashSaleClothes2 clothes) {
        this.clothes = clothes;
    }

    @Override
    public Integer call() {
        try {
            lock.lock();
            //业务代码
            return clothes.saleOne();
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        } finally {
            lock.unlock();
        }
    }

}


@Data
class FlashSaleClothes2 {
    // 衣服数量
    private int number;

    public FlashSaleClothes2(int number) {
        this.number = number;
    }

    public int saleOne() {
        if (number == 0) {
            System.out.print(Thread.currentThread().getName() + " --> 抢购失败(无货)");
            return 0;
        }
        try {
            TimeUnit.MILLISECONDS.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(
                Thread.currentThread().getName() + " --> 抢到了 --> " + number--
        );
        return 1;
    }
}