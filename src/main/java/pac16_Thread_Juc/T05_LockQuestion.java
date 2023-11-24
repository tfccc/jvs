package pac16_Thread_Juc;

import lombok.SneakyThrows;
import lombok.Synchronized;
import java.util.concurrent.TimeUnit;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-21 18:52
 * @desc: �����������⼰���
 *
 * 1.���Ķ���-->������-->[1.ʵ������, 2.ģ��]
 * 2.һ������ֻ��һ����, һ��ClassҲֻ��һ����
 * 3.���õ�������ִ��
 * 4.ʵ��������ʵ������, ��̬������Class
 * 5.δ�����ķ����������������
 *
 **/

public class T05_LockQuestion {

    public static void main(String[] args) throws Exception {
        test1();
    }

    private static void test1() throws InterruptedException {
        Phone phone1 = new Phone();
        new Thread(phone1::sendMessage, "�߳�1").start();
        new Thread(phone1::call, "�߳�2").start();
    }

    private static void test2() throws InterruptedException {
        Phone phone1 = new Phone();
        new Thread(phone1::sendMessage, "�߳�1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(Phone::callStatic, "�߳�2").start();
        new Thread(phone1::unlockedMethod, "�߳�3").start();
    }

}

class Phone {
    private final Object lock1 = new Object[0];
    private final Object lock2 = new Object();

    @SneakyThrows
    @Synchronized
    public void sendMessage() {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1.������");
    }

    @SneakyThrows
    @Synchronized
    public void call() {
        System.out.println("2.��绰");
    }

    @SneakyThrows
    public static synchronized void sendMessageStatic() {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1.������(��̬)");
    }

    public static synchronized void callStatic() {
        System.out.println("2.��绰(��̬)");
    }

    public void unlockedMethod() {
        System.out.println("3.δ����");
    }
}
