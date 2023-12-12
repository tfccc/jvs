package pac16_Thread_Juc;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * @author Frank.Tang
 * @date 2023-12-12 11:43
 * @desc
 **/
public class T10_PriorityBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        for (int i = 1; i <= 5; i++) {
            PriorityBlockingQueue<Integer> queue = new PriorityBlockingQueue<>(
                    11,
                    // �Զ������ȼ�����, ��ߵ����ȳ���
                    (o1, o2) -> o1.compareTo(o2)
            );
            queue.offer(6);
            queue.offer(2);
            queue.offer(5);
            queue.offer(1);
            queue.offer(4);
            queue.offer(3);

            Integer take1 = queue.poll();
            Integer take2 = queue.poll();
            System.out.print(take1 + " ");
            System.out.println(take2);
        }
    }

}
