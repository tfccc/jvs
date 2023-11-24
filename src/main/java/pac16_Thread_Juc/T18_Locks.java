package pac16_Thread_Juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-24 10:13
 * @desc: ���ļ������
 *
 * һ.��ƽ��
 *      * ��������(�ȵ��߳�������)
 *
 * ��.�ǹ�ƽ��
 *      * ���Բ��, Ч�ʽϹ�ƽ������(�������߳̿ɲ��)
 *
 * ��.��������(�ݹ���)
 *      * һ���̲߳����ͷ�[��A]�������ظ��Ļ�ȡ[��A]n�Σ�ֻ�����ͷŵ�ʱ��Ҳ��Ҫ��Ӧ���ͷ�n��
 *      * synchronized��ReentrantLock��
 *
 * ��.������
 *      * ��whileѭ������ʽ, �����ж�ֱ������������Ž���(����ѭ��)
 *
 * ��.����
 *      * �������̻�����жԷ���Ҫ����, �໥�ȴ��ͷ�, ���һֱ�ȴ�
 *      �Ų鷽��:
 *          (1)jps�鿴����
 *          (2)jstack + ���̺� �鿴��ϸ
 *          (3)��ϸ��Ϣ�ڻ��г�����������
 *
 * ��.��д��
 *  {@link T09_ReadWriteLock}
 *
 * ��.�ֹ۱�����
 *
 **/
public class T18_Locks {

    public static void main(String[] args) throws InterruptedException {
        //reentrantLock();
        deadLock();
    }


    /*****************************************************************
     *                  ��.��������(ʹ��lock()���ֶ��ͷ�)
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
     *                              ��.����
     *****************************************************************/
    static void deadLock() {
        String str1 = "111";
        String str2 = "222";
        new Thread(new DeadLock(str1, str2), "�߳�1").start();
        new Thread(new DeadLock(str2, str1), "�߳�2").start();
/*
        DeadLockRl deadLockRl = new DeadLockRl();
        new Thread(deadLockRl::test1, "�߳�1").start();
        new Thread(deadLockRl::test2, "�߳�2").start();*/
    }

}

class Phone2 {

    public synchronized void sendMsg() {
        System.out.println(Thread.currentThread().getName() + " -- ������");
        call();
    }

    public synchronized void call() {
        System.out.println(Thread.currentThread().getName() + " -- ��绰");
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
                " locked ��1 wanna ��2 ");
        try {
            TimeUnit.MILLISECONDS.sleep(1000 * 5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() +
                " �ͷ� ��1 ");
        lock1.unlock();
        System.out.println(Thread.currentThread().getName() +
                " begin to lock ��2 ");
        lock2.lock();
    }

    public void test2() {
        lock2.lock();
        System.out.println(Thread.currentThread().getName() +
                " locked ��2 wanna ��1 ");
        try {
            TimeUnit.MILLISECONDS.sleep(1000 * 10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() +
                " �ͷ� ��2 ");
        lock2.unlock();
        System.out.println(Thread.currentThread().getName() +
                " begin to lock ��1 ");
        lock1.lock();
    }
}