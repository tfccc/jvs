package pac16_Thread_Juc;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Frank.Tang
 * @date 2023-12-12 16点01分
 * @desc ReentrantReadWriteLock:
 *          1.允许[读/读]并发 (不互斥)
 *          2.不允许[读/写]、[写/写]并发 (互斥)
 */
public class T18_RWLock {

    public static void main(String[] args) throws InterruptedException {
        //rr();
        rw();
    }

    /*****************************************************************
     *                          允许读/读并发
     *****************************************************************/
    private static void rr() throws InterruptedException {
        new Thread(() -> {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get readLock");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock readLock");
        }, "读线程1").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get readLock");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock readLock");
        }, "读线程2").start();
    }

    /*****************************************************************
     *                          不允许读/写并发
     *****************************************************************/
    private static void rw() throws InterruptedException {
        new Thread(() -> {
            lock.readLock().lock();
            System.out.println(Thread.currentThread().getName() + " get readLock, sleep 8s");
            try {
                TimeUnit.SECONDS.sleep(8);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.readLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock readLock");
        }, "读线程").start();

        TimeUnit.SECONDS.sleep(1);

        new Thread(() -> {
            lock.writeLock().lock();
            System.out.println(Thread.currentThread().getName() + " get writeLock, sleep 2s");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.writeLock().unlock();
            System.out.println(Thread.currentThread().getName() + " unlock writeLock");
        }, "写线程").start();
    }


    /** 定义一个Map来模拟缓存 */
    private static final Map<String, Object> cache = new HashMap<>();
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * 模拟Hibernate缓存,优先缓存，若缓存不存在写锁更新
     */
    public static Object getData(String key) {

        /* 上读锁 */
        lock.readLock().lock();
        /* 定义从缓存中读取的对象 */
        Object value = null;

        try {
            /* 从缓存中读取数据 */
            value = cache.get(key);

            if (value == null) {
                /* 如果缓存中没有数据，我们就把读锁关闭，直接上写锁【让一个线程去数据库中取数据】 */
                lock.readLock().unlock();
                /* 上写锁 */
                lock.writeLock().lock();

                try {
                    /* 上了写锁之后再判断一次【我们只让一个线程去数据库中取值即可，当第二个线程过来的时候，发现value不为空了就去缓存中取值】 */
                    if (value == null) {
                        /* 模拟去数据库中取值 */
                        value = "hello";
                        System.out.println("修改换缓存");
                        cache.put(key, value);
                    }
                } finally {
                    /* 写完之后把写锁关闭 */
                    lock.writeLock().unlock();
                }
                /* 缓存中已经有了数据，我们再把已经 关闭的读锁打开 */
                lock.readLock().lock();
            }
            return value;

        } finally {
            /* 最后把读锁也关闭 */
            lock.readLock().unlock();
        }

    }
}