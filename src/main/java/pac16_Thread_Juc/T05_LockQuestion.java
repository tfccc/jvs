package pac16_Thread_Juc;

import lombok.SneakyThrows;
import lombok.Synchronized;
import java.util.concurrent.TimeUnit;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-21 18:52
 * @desc: 关于锁的问题及理解
 *
 * 1.锁的对象-->调用者-->[1.实例对象, 2.模板]
 * 2.一个对象只有一把锁, 一个Class也只有一把锁
 * 3.先拿到锁的先执行
 * 4.实例方法锁实例本身, 静态方法锁Class
 * 5.未加锁的方法不会参与锁竞争
 *
 **/

public class T05_LockQuestion {

    public static void main(String[] args) throws Exception {
        test1();
    }

    private static void test1() throws InterruptedException {
        Phone phone1 = new Phone();
        new Thread(phone1::sendMessage, "线程1").start();
        new Thread(phone1::call, "线程2").start();
    }

    private static void test2() throws InterruptedException {
        Phone phone1 = new Phone();
        new Thread(phone1::sendMessage, "线程1").start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(Phone::callStatic, "线程2").start();
        new Thread(phone1::unlockedMethod, "线程3").start();
    }

}

class Phone {
    private final Object lock1 = new Object[0];
    private final Object lock2 = new Object();

    @SneakyThrows
    @Synchronized
    public void sendMessage() {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1.发短信");
    }

    @SneakyThrows
    @Synchronized
    public void call() {
        System.out.println("2.打电话");
    }

    @SneakyThrows
    public static synchronized void sendMessageStatic() {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("1.发短信(静态)");
    }

    public static synchronized void callStatic() {
        System.out.println("2.打电话(静态)");
    }

    public void unlockedMethod() {
        System.out.println("3.未加锁");
    }
}
