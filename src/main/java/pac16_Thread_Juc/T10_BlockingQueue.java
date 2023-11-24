package pac16_Thread_Juc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.concurrent.*;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-22 14:00
 * @desc: ��������: û��ʱ����ȡ(����), ���˲��ܼ�(����)
 *
 * 4�����:
 *      1.���쳣
 *      2.�����쳣
 *      3.����(�ȴ�), һֱ��
 *      4.����(�ȴ�), ��ʱ�˳�
 *
 **/
public class T10_BlockingQueue {

    @Test
    @DisplayName("1.���쳣")
    public void test1() {
        BlockingQueue<Object> queue = new ArrayBlockingQueue<>(2);

        System.out.println(queue.add(1));
        System.out.println(queue.add(2));
        System.out.println(queue.add(3));

        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

        System.out.println(queue.element());
    }

    @Test
    @DisplayName("2.�����쳣")
    public void test2() {
        BlockingQueue<Object> queue = new ArrayBlockingQueue<>(2);

        System.out.println(queue.offer(1));
        System.out.println(queue.offer(2));
        System.out.println(queue.offer(3));

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue.peek());
    }


    @Test
    @DisplayName("3.����(�ȴ�)")
    public void test3() throws InterruptedException {
        BlockingQueue<Object> queue = new ArrayBlockingQueue<>(2);

        queue.put(1);
        queue.put(2);
        //queue.put(3);

        System.out.println(queue.take());
        System.out.println(queue.take());
        System.out.println(queue.take());

    }


    @Test
    @DisplayName("4.����(�ȴ�), ��ʱ����")
    public void test4() throws InterruptedException {
        BlockingQueue<Object> queue = new ArrayBlockingQueue<>(2);

        System.out.println(queue.offer(1, 1, TimeUnit.SECONDS));
        System.out.println(queue.offer(2, 1, TimeUnit.SECONDS));
        System.out.println(queue.offer(3, 1, TimeUnit.SECONDS));

        System.out.println(queue.poll(1, TimeUnit.SECONDS));
        System.out.println(queue.poll(1, TimeUnit.SECONDS));
        System.out.println(queue.poll(1, TimeUnit.SECONDS));
    }

}
