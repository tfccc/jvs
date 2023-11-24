package pac16_Thread_Juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-23 11:49
 * @desc: volatile关键字
 *
 * 1. 保证可见性(实时和主存保持刷新)
 * 2. 不保证原子性(一般变量的也不保证)(不可分割的,要么同时成功,要么同时失败)
 * 3. 禁止指令重排, 保证执行顺序(编译器重排、指令并行重排、内存系统重排等)
 *
 **/
public class T14_Volatile {

    public static void main(String[] args) throws Exception {
        test1_1_inVisible();
        //test1_2_volatile();
        //test2_atomicityNotGuaranteed();
    }


    /*****************************************************************
     *                          1.保证可见性
     *****************************************************************/
    private static int num1 = 0;
    //volatile修饰
    private volatile static int num2 = 0;

    static void test1_1_inVisible() throws InterruptedException {
        //此处t1对主内存的变化不可见(空循环体)
        new Thread(() -> {
            while (num1 == 0) {

            }
        }, "t1").start();
        TimeUnit.MILLISECONDS.sleep(1010);
        //主线程修改值
        num1 = 1;
        System.out.println("change num to 1...");
    }

    static void test1_2_volatile() throws InterruptedException {
        //此处t1对主内存的变化不可见
        new Thread(() -> {
            while (num2 == 0) {

            }
        }, "t1").start();
        TimeUnit.MILLISECONDS.sleep(1010);
        //主线程修改值
        num2 = 1;
        System.out.println("change num to 1...");
    }


    /*****************************************************************
     *                         2.不保证原子性
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
     *                         3.禁止指令重排
     * @see T15_Singleton (DCL)
     *****************************************************************/
    static void test3() {

    }
}
