package pac05_Thread;

/**
 * @author TFC
 * @date 2019��7��19�� ����11:11:26
 * @note ����(�߳�ִ�в��� �� �໥���ͷ���Դ �� �Ӷ��໥�ȴ�)
 *
 *  ����:��Ҫ��ͬһ��������У�ͬʱ���жԸ��������
 */
public class T21_DeadLock {

    public static String obj1 = "obj1";
    public static String obj2 = "obj2";


    public static void main(String[] args) {
        lock();
    }


    //�������:a,b�߳�ͬʱ������Դ�������໥�ȴ�
    static void lock() {
        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();
    }

    //�������
    static void nolock() {
        //1.ȥ�����������Ƕ��syn���
        //2.ȥ������һ���̣߳��޾���
    }
}

class Lock1 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("�߳�1  running");
            while (true) {
                synchronized (T21_DeadLock.obj1) {
                    System.out.println("�߳�1  ����  obj1");
                    Thread.sleep(1000);//��ȡobj1���ȵ�һ�������Lock2���㹻��ʱ����סobj2
                    synchronized (T21_DeadLock.obj2) {
                        System.out.println("�߳�1  ����  obj2");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Lock2 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("�߳�2  running");
            while (true) {
                synchronized (T21_DeadLock.obj2) {
                    System.out.println("�߳�2  ����  obj2");
                    Thread.sleep(1000);
                    synchronized (T21_DeadLock.obj1) {
                        System.out.println("�߳�2  ����  obj1");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}