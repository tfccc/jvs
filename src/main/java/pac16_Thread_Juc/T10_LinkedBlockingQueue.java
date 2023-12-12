package pac16_Thread_Juc;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Frank.Tang
 * @date 2023-12-12 11:34
 * @desc
 *
 * 相同点：ArrayBlockingQueue和LinkedBlockingQueue都是通过condition通知机制来实现可阻塞式插入和删除元素，并满足线程安全的特性。
 *
 * 不同点：
 *   1.数据结构：ArrayBlockingQueue使用数组作为底层数据结构，而LinkedBlockingQueue使用链表作为底层数据结构。
 *   2.容量限制：ArrayBlockingQueue的容量是固定的，需要在创建时指定容量大小；而LinkedBlockingQueue的容量可
 *     以选择不限制大小（默认Integer.MAX_VALUE）或者在创建时指定容量大小。
 *   3.性能：由于ArrayBlockingQueue使用数组实现，插入和移除元素时无需进行链表的节点操作，因此在高并发环境下，
 *     ArrayBlockingQueue的性能通常比LinkedBlockingQueue更好。
 *   4.并发度：ArrayBlockingQueue在插入和删除元素时只需要获取一个全局锁，即lock，这意味着多个线程无法同时进行
 *     插入和删除操作，可能会限制并发度；而LinkedBlockingQueue在插入和删除元素时分别采用了putLock和takeLock，
 *     使得多个线程可以同时进行操作，从而提高了并发度。
 *
 * 总的来说，如果对并发度要求不高，且需要固定大小的有界队列，可以选择ArrayBlockingQueue；如果对并发度要求较高，且
 * 需要动态调整大小的无界队列，可以选择LinkedBlockingQueue。
 *
 **/
public class T10_LinkedBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>();

        queue.put("111");

        Object take = queue.take();
        System.out.println(take);
    }

}
