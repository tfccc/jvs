package pac16_Thread_Juc;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Frank.Tang
 * @date 2023-12-12 16��01��
 * @desc ReentrantReadWriteLock:
 *          1.����[��/��]���� (������)
 *          2.������[��/д]��[д/д]���� (����)
 */
public class T18_RWLock {

    public static void main(String[] args) throws InterruptedException {
        //rr();
        rw();
    }

    /*****************************************************************
     *                          �����/������
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
        }, "���߳�1").start();

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
        }, "���߳�2").start();
    }

    /*****************************************************************
     *                          �������/д����
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
        }, "���߳�").start();

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
        }, "д�߳�").start();
    }


    /** ����һ��Map��ģ�⻺�� */
    private static final Map<String, Object> cache = new HashMap<>();
    private static final ReadWriteLock lock = new ReentrantReadWriteLock();

    /**
     * ģ��Hibernate����,���Ȼ��棬�����治����д������
     */
    public static Object getData(String key) {

        /* �϶��� */
        lock.readLock().lock();
        /* ����ӻ����ж�ȡ�Ķ��� */
        Object value = null;

        try {
            /* �ӻ����ж�ȡ���� */
            value = cache.get(key);

            if (value == null) {
                /* ���������û�����ݣ����ǾͰѶ����رգ�ֱ����д������һ���߳�ȥ���ݿ���ȡ���ݡ� */
                lock.readLock().unlock();
                /* ��д�� */
                lock.writeLock().lock();

                try {
                    /* ����д��֮�����ж�һ�Ρ�����ֻ��һ���߳�ȥ���ݿ���ȡֵ���ɣ����ڶ����̹߳�����ʱ�򣬷���value��Ϊ���˾�ȥ������ȡֵ�� */
                    if (value == null) {
                        /* ģ��ȥ���ݿ���ȡֵ */
                        value = "hello";
                        System.out.println("�޸Ļ�����");
                        cache.put(key, value);
                    }
                } finally {
                    /* д��֮���д���ر� */
                    lock.writeLock().unlock();
                }
                /* �������Ѿ��������ݣ������ٰ��Ѿ� �رյĶ����� */
                lock.readLock().lock();
            }
            return value;

        } finally {
            /* ���Ѷ���Ҳ�ر� */
            lock.readLock().unlock();
        }

    }
}