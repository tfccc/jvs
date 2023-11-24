package pac00_Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {
    int tag = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();


    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();

        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
                foo.first(() -> System.out.print(" first "));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t1").start();
        new Thread(() -> {
            try {
                foo.second(() -> System.out.print(" second "));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t2").start();
        new Thread(() -> {
            try {
                foo.third(() -> System.out.print(" third "));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }, "t3").start();

    }

    public void first(Runnable printFirst) throws InterruptedException {
        lock.lock();
        try {
            while (tag != 1)
                condition1.await();

            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();

            tag = 2;
            condition2.signal();
        } catch (Exception e) {
            throw e;
        } finally {
            lock.unlock();
        }

    }

    public void second(Runnable printSecond) throws InterruptedException {
        lock.lock();
        try {
            while (tag != 2)
                condition2.await();

            // printFirst.run() outputs "first". Do not change or remove this line.
            printSecond.run();

            tag = 3;
            condition3.signal();
        } catch (Exception e) {
            throw e;
        } finally {
            lock.unlock();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        lock.lock();
        try {
            while (tag != 3l)
                condition3.await();

            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();

            tag = 1;
            condition1.signal();
        } catch (Exception e) {
            throw e;
        } finally {
            lock.unlock();
        }
    }
}