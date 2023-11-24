package pac16_Thread_Juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-23 11:49
 * @desc: volatile�ؼ���
 *
 * 1. ��֤�ɼ���(ʵʱ�����汣��ˢ��)
 * 2. ����֤ԭ����(һ�������Ҳ����֤)(���ɷָ��,Ҫôͬʱ�ɹ�,Ҫôͬʱʧ��)
 * 3. ��ָֹ������, ��ִ֤��˳��(���������š�ָ������š��ڴ�ϵͳ���ŵ�)
 *
 **/
public class T14_Volatile {

    public static void main(String[] args) throws Exception {
        test1_1_inVisible();
        //test1_2_volatile();
        //test2_atomicityNotGuaranteed();
    }


    /*****************************************************************
     *                          1.��֤�ɼ���
     *****************************************************************/
    private static int num1 = 0;
    //volatile����
    private volatile static int num2 = 0;

    static void test1_1_inVisible() throws InterruptedException {
        //�˴�t1�����ڴ�ı仯���ɼ�(��ѭ����)
        new Thread(() -> {
            while (num1 == 0) {

            }
        }, "t1").start();
        TimeUnit.MILLISECONDS.sleep(1010);
        //���߳��޸�ֵ
        num1 = 1;
        System.out.println("change num to 1...");
    }

    static void test1_2_volatile() throws InterruptedException {
        //�˴�t1�����ڴ�ı仯���ɼ�
        new Thread(() -> {
            while (num2 == 0) {

            }
        }, "t1").start();
        TimeUnit.MILLISECONDS.sleep(1010);
        //���߳��޸�ֵ
        num2 = 1;
        System.out.println("change num to 1...");
    }


    /*****************************************************************
     *                         2.����֤ԭ����
     *   (if wanna get right res, use [Lock] or [syn] or [Atomic])
     *****************************************************************/
    private static int num3 = 0;
    private static AtomicInteger num4 = new AtomicInteger(0);

    static void test2_atomicityNotGuaranteed() throws InterruptedException {
        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    num3++;
                }
            }).start();
        }
        // excepted res = 20000
        TimeUnit.MILLISECONDS.sleep(1000);
        // real res is not 20000
        System.out.println(num3);
    }


    /*****************************************************************
     *                         3.��ָֹ������
     * @see T15_Singleton (DCL)
     *****************************************************************/
    static void test3() {

    }
}
