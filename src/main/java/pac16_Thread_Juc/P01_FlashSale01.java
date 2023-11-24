package pac16_Thread_Juc;

import lombok.Data;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-20 20:09
 * @desc: ��ͳ��ʽģ����Ʒ����
 **/
public class P01_FlashSale01 {

    public static void main(String[] args) {
        FlashSaleClothes1 clothes = new FlashSaleClothes1(50);
        Random random = new Random();

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                while (clothes.getNumber() != 0) {
                    clothes.saleOne();
                    try {
                        TimeUnit.MILLISECONDS.sleep(random.nextInt(500));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }, "�û�" + (i < 10 ? i + " " : i)
            ).start();
        }

    }

}

@Data
class FlashSaleClothes1 {
    // �·�����
    private int number;
    Lock lock = new ReentrantLock();

    public FlashSaleClothes1(int number) {
        this.number = number;
    }

    public synchronized void saleOne() {
        if (number == 0) {
            System.out.println(
                    Thread.currentThread().getName() +
                            " --> ����ʧ��(�޻�)"
            );
        } else {
            System.out.println(
                    Thread.currentThread().getName() +
                            " --> ������ --> " +
                            number--
            );
        }
    }
}