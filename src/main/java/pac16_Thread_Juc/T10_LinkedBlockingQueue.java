package pac16_Thread_Juc;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Frank.Tang
 * @date 2023-12-12 11:34
 * @desc
 *
 * ��ͬ�㣺ArrayBlockingQueue��LinkedBlockingQueue����ͨ��condition֪ͨ������ʵ�ֿ�����ʽ�����ɾ��Ԫ�أ��������̰߳�ȫ�����ԡ�
 *
 * ��ͬ�㣺
 *   1.���ݽṹ��ArrayBlockingQueueʹ��������Ϊ�ײ����ݽṹ����LinkedBlockingQueueʹ��������Ϊ�ײ����ݽṹ��
 *   2.�������ƣ�ArrayBlockingQueue�������ǹ̶��ģ���Ҫ�ڴ���ʱָ��������С����LinkedBlockingQueue��������
 *     ��ѡ�����ƴ�С��Ĭ��Integer.MAX_VALUE�������ڴ���ʱָ��������С��
 *   3.���ܣ�����ArrayBlockingQueueʹ������ʵ�֣�������Ƴ�Ԫ��ʱ�����������Ľڵ����������ڸ߲��������£�
 *     ArrayBlockingQueue������ͨ����LinkedBlockingQueue���á�
 *   4.�����ȣ�ArrayBlockingQueue�ڲ����ɾ��Ԫ��ʱֻ��Ҫ��ȡһ��ȫ��������lock������ζ�Ŷ���߳��޷�ͬʱ����
 *     �����ɾ�����������ܻ����Ʋ����ȣ���LinkedBlockingQueue�ڲ����ɾ��Ԫ��ʱ�ֱ������putLock��takeLock��
 *     ʹ�ö���߳̿���ͬʱ���в������Ӷ�����˲����ȡ�
 *
 * �ܵ���˵������Բ�����Ҫ�󲻸ߣ�����Ҫ�̶���С���н���У�����ѡ��ArrayBlockingQueue������Բ�����Ҫ��ϸߣ���
 * ��Ҫ��̬������С���޽���У�����ѡ��LinkedBlockingQueue��
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
