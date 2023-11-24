package pac16_Thread_Juc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-23 19:51
 * @desc: ABA: a-->b-->a (a��b, �ֱ��a)
 *
 * һ.ABA��������:
 *      (0)����x=0
 *      (1)�߳�a�޸�x=1
 *      (2)�߳�a�޸�x=0
 *      (3)�߳�b����x, ����x=0��b���ڴ�ֵ, �����в���
 *
 * ��.�������: �Ӱ汾��/ʱ����ȿ��� {@link AtomicStampedReference}
 *
 **/
public class T17_ABA {

    public static void main(String[] args) {
        //abaQuestion();
        //stamped();

    }

    static void abaQuestion() {
        AtomicInteger integer = new AtomicInteger(1);
        boolean b1 = integer.compareAndSet(1, 2);
        System.out.println(b1);
        System.out.println(integer.get());

        boolean b2 = integer.compareAndSet(2, 1);
        System.out.println(b2);
        System.out.println(integer.get());

        boolean b3 = integer.compareAndSet(1, 9);
        System.out.println(b3);
        System.out.println(integer.get());
    }

    static void stamped() {
        AtomicStampedReference<Integer> integer =
                new AtomicStampedReference<>(1, 100);

        new Thread(() -> {
            System.out.println("a1-->" + integer.getStamp());

            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("a__set1__" + integer.compareAndSet(
                    1,
                    10,
                    integer.getStamp(),
                    integer.getStamp() + 1
            ));
            System.out.println("a2-->" + integer.getStamp());

            System.out.println("a__set2__" + integer.compareAndSet(
                    10,
                    1,
                    integer.getStamp(),
                    integer.getStamp() + 1
            ));
            System.out.println("a3-->" + integer.getStamp());
        }).start();

        new Thread(() -> {
            int stamp1 = integer.getStamp();
            System.out.println("b1-->" + stamp1);

            try {
                TimeUnit.MILLISECONDS.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("b__set2__" + integer.compareAndSet(
                    1,
                    10,
                    stamp1,
                    integer.getStamp() + 1
            ));
            System.out.println("b2-->" + integer.getStamp());
        }).start();


    }

}
