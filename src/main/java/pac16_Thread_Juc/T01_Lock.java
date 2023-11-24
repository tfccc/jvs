package pac16_Thread_Juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-20 20:24
 * @desc: Lock锁实现抢票
 *
 * 步骤:
 *      1.new ReentrantLock()
 *      2.lock()加锁
 *      3.finally -- >unlock()解锁
 *
 **/
public class T01_Lock {
    static int n = 100;

    public static void main(String[] args) {
        Ticket ticket = new Ticket();

        new Thread(() -> {
            for (int i = 0; i < n; i++) ticket.sale();
        }, "1").start();
        new Thread(() -> {
            for (int i = 0; i < n; i++) ticket.sale();
        }, "2").start();
        new Thread(() -> {
            for (int i = 0; i < n; i++) ticket.sale();
        }, "3").start();

    }

}


class Ticket {
    private Integer num = 100;

    Lock lock = new ReentrantLock();

    public /*synchronized*/ void sale() {
        lock.lock();
        try {
            if (num > 0) {
                TimeUnit.MILLISECONDS.sleep(20);
                System.out.println("线程" + Thread.currentThread().getName()
                        + " --> " + (num--));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

}