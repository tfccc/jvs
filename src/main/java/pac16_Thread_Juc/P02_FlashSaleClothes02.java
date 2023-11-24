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
 * @desc: Lock+Callableģ����Ʒ����
 **/
public class P02_FlashSaleClothes02 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FlashSaleClothes2 sale = new FlashSaleClothes2(100);
        for (int i = 1; i <= 120; i++) {
            UserThread userThread = new UserThread(sale);
            FutureTask<Integer> task = new FutureTask<>(userThread);
            new Thread(task, "�û�" + i).start();
            //get���ܻ��������(��������, �����첽ͨ��)
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
            //ҵ�����
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
    // �·�����
    private int number;

    public FlashSaleClothes2(int number) {
        this.number = number;
    }

    public int saleOne() {
        if (number == 0) {
            System.out.print(Thread.currentThread().getName() + " --> ����ʧ��(�޻�)");
            return 0;
        }
        try {
            TimeUnit.MILLISECONDS.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.print(
                Thread.currentThread().getName() + " --> ������ --> " + number--
        );
        return 1;
    }
}