package pac16_Thread_Juc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-22 14:38
 * @desc: ???????: ??????????, ???????????,?????????????????
 **/
public class T11_SynchronousQueue {
    // TODO: 2020/9/22 unResolved

    public static void main(String[] args) throws InterruptedException {
        test1();
    }

    public static void test1() throws InterruptedException {
        BlockingQueue<Object> queue = new SynchronousQueue<>();

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            try {
                for (int i = 1; i <= 10; i++) {
                    TimeUnit.MILLISECONDS.sleep(300);
                    queue.put(i);
                    System.out.println(name + "--put--" + i);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1").start();


        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            String name = Thread.currentThread().getName();
            try {
                while (true) {
                    System.out.println(name + "--take--" + queue.take());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2").start();

        TimeUnit.MILLISECONDS.sleep(1000 * 30);
    }

}
