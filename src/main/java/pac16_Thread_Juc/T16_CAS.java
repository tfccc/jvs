package pac16_Thread_Juc;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-23 19:26
 * @desc: CAS: compare and swap
 *
 * һ.ԭ��: �Ƚϵ�ǰ�����ڴ�������ֵ, �����������ֵ, ִ�в���, ����ѭ��ֱ����������
 *
 * ��.ȱ��:
 *      1.ѭ��(����)���ʱ
 *      2.һ����ֻ�ܱ�֤һ�����������ԭ����
 *      3.����ABA����
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
