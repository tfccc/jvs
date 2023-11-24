package pac16_Thread_Juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-23 19:26
 * @desc: CAS: compare and swap
 *
 * 一.原理: 比较当前工作内存和主存的值, 如果是期望的值, 执行操作, 否者循环直至满足条件
 *
 * 二.缺点:
 *      1.循环(自旋)会耗时
 *      2.一次性只能保证一个共享变量的原子性
 *      3.存在ABA问题
 *
 **/
public class T16_CAS {

    public static void main(String[] args) {
        casInAtomic();
    }


    static void casInAtomic() {
        AtomicInteger integer = new AtomicInteger(0);
        boolean b = integer.compareAndSet(0, 10);
        System.out.println(b);
        System.out.println(integer.get());

    }

}
