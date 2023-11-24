package pac16_Thread_Juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-21 12:46
 * @desc: 生消3: Lock + Condition版本 (精准唤醒)
 *
 * A-->B-->C
 *
 **/
public class T04_AccurateAwake {
    static int lr = 10;

    public static void main(String[] args) {
        Product3 product = new Product3();

        new Thread(() -> {
            //for (int i = 0; i < lr; i++) {
                product.a();
            //}
        }, "A").start();

        new Thread(() -> {
           // for (int i = 0; i < lr; i++) {
                product.b();
           // }
        }, "B").start();

        new Thread(() -> {
            //for (int i = 0; i < lr; i++) {
                product.c();
           // }
        }, "C").start();

    }

}


class Product3 {
    private int number = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();

    public void a() {
        try {
            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.lock();

            while (number != 1) {
                try {
                    condition1.await();
                    System.out.println("condition1.await()");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "-->通知" + "B");
            number++;
            condition2.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void b() {
        try {
            lock.lock();
            while (number != 2) {
                try {
                    condition2.await();
                    System.out.println("condition2.await()");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "-->通知" + "C");
            number++;
            condition3.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void c() {
        try {
            lock.lock();
            while (number != 3) {
                try {
                    condition3.await();
                    System.out.println("condition3.await()");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "-->通知" + "A");
            number = 1;
            condition1.signal();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}

