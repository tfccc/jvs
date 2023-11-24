package pac16_Thread_Juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-24 10:13
 * @desc: 锁的几大分类
 *
 * 一.公平锁
 *      * 不允许插队(先到线程先拿锁)
 *
 * 二.非公平锁
 *      * 可以插队, 效率较公平锁更高(后来的线程可插队)
 *
 * 三.可重入锁(递归锁)
 *      * 一个线程不用释放[锁A]，可以重复的获取[锁A]n次，只是在释放的时候，也需要相应的释放n次
 *      * synchronized、ReentrantLock等
 *
 * 四.自旋锁
 *      * 以while循环的形式, 不断判断直到符合条件后才解锁(跳出循环)
 *
 * 五.死锁
 *      * 两个进程互相持有对方需要的锁, 相互等待释放, 造成一直等待
 *      排查方法:
 *          (1)jps查看进程
 *          (2)jstack + 进程号 查看详细
 *          (3)详细信息内会列出产生的死锁
 *
 * 六.读写锁
 *  {@link T09_ReadWriteLock}
 *
 * 七.乐观悲观锁
 *
 **/
public class T18_Locks {

    public static void main(String[] args) throws InterruptedException {
        //reentrantLock();
        deadLock();
    }


    /*****************************************************************
     *                  三.可重入锁(使用lock()需手动释放)
     *****************************************************************/
    static void reentrantLock() {
        Phone2 phone = new Phone2();
        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                phone.sendMsg();
            }, "A" + i).start();
        }

        for (int i = 1; i <= 5; i++) {
            new Thread(() -> {
                phone.sendMsg();
            }, "BBB" + i).start();
        }
    }


    /*****************************************************************
     *                              五.死锁
     *****************************************************************/
    static void deadLock() {
        String str1 = "111";
        String str2 = "222";
        new Thread(new DeadLock(str1, str2), "线程1").start();
        new Thread(new DeadLock(str2, str1), "线程2").start();
/*
        DeadLockRl deadLockRl = new DeadLockRl();
        new Thread(deadLockRl::test1, "线程1").start();
        new Thread(deadLockRl::test2, "线程2").start();*/
    }

}

class Phone2 {

    public synchronized void sendMsg() {
        System.out.println(Thread.currentThread().getName() + " -- 发短信");
        call();
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + " -- 打电话");
    }
}

class DeadLock implements Runnable {
    private String str1;
    private String str2;

    public DeadLock(String str1, String str2) {
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public void run() {

        synchronized (str1) {
            System.out.println(Thread.currentThread().getName() +
                    " locked " + str1 + " --- wanna " + str2);
            try {
                TimeUnit.MILLISECONDS.sleep(1000 * 20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +
                    " begin to try lock " + str2);
            synchronized (str2) {
                System.out.println(Thread.currentThread().getName() +
                        " locked " + str2 + " --- wanna " + str1);
            }
        }
    }
}

class DeadLockRl {
    ReentrantLock lock1 = new ReentrantLock();
    ReentrantLock lock2 = new ReentrantLock();

    public void test1() {
        lock1.lock();
        System.out.println(Thread.currentThread().getName() +
                " locked 锁1 wanna 锁2 ");
        try {
            TimeUnit.MILLISECONDS.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() +
                " 释放 锁1 ");
        lock1.unlock();
        System.out.println(Thread.currentThread().getName() +
                " begin to lock 锁2 ");
        lock2.lock();
    }

    public void test2() {
        lock2.lock();
        System.out.println(Thread.currentThread().getName() +
                " locked 锁2 wanna 锁1 ");
        try {
            TimeUnit.MILLISECONDS.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +
                " 释放 锁2 ");
        lock2.unlock();
        System.out.println(Thread.currentThread().getName() +
                " begin to lock 锁1 ");
        lock1.lock();
    }
}