package pac16_Thread_Juc;

import lombok.Data;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author Frank.Tang
 * @date 2023-12-12 10:57
 * @desc
 *       1.take() ��һֱ����������ȡԪ��
 *       2.poll() ��ֱ����, û�о���null
 *       3.poll(time) ���û��Ԫ��, ��ȴ�һ��ʱ��, ֱ������ʱ��
 **/
public class T10_DelayQueue {

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<MyDelay> delayQueue = new DelayQueue<>();

        MyDelay delay1 = new MyDelay("order01", 1000L * 2);
        MyDelay delay2 = new MyDelay("order01", 1000L * 8);

        delayQueue.offer(delay1);
        delayQueue.offer(delay2);
        System.out.println("insert to queue");

        MyDelay take1 = delayQueue.take();
        System.out.println(take1.getName() + ": got ele from queue");

        MyDelay take2 = delayQueue.take();
        System.out.println(take2.getName() + ": got ele from queue");

        //delayQueue.poll();
    }

}

@Data
class MyDelay implements Delayed {

    private String name;
    private final long delayTime;

    public MyDelay(String name, long delayTime) {
        // �ӳ�ʱ��ӵ�ǰʱ��
        this.name = name;
        this.delayTime = System.currentTimeMillis() + delayTime;
        System.out.println("new MyDelay, delayTime: " + this.delayTime + "ms");
    }

    // ��ȡ����ʣ��ʱ��
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(delayTime - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed o) {
        return Long.compare(delayTime, ((MyDelay) o).delayTime);
    }
}
