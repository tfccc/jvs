package pac16_Thread_Juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-21 12:17
 * @desc: 生消2: Lock + Condition版本
 **/
public class T03_PC2_LockCondition {
    static int lr = 100;

    public static void main(String[] args) {
        Product2 product = new Product2();

        new Thread(() -> {
            for (int i = 0; i < lr; i++) {
                product.produce();
            }
        }, "P1").start();

        new Thread(() -> {
            for (int i = 0; i < lr; i++) {
                product.produce();
            }
        }, "P22").start();

        new Thread(() -> {
            for (int i = 0; i < lr; i++) {
                product.consume();
            }
        }, "C1").start();

        new Thread(() -> {
            for (int i = 0; i < lr; i++) {
                product.consume();
            }
        }, "C22").start();
    }

}


class Product2 {
    private int number = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void produce() {
        try {
            lock.lock();

            while (number != 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "生产: " + ++number);
            condition.signalAll();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        try {
            lock.lock();
            while (number == 0) {
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "消费: " + --number);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
