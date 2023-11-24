package pac16_Thread_Juc;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-21 20:35
 * @desc: juc提供的CopyOnWriteArrayList(解决ArrayList多线程不安全的问题)
 **/
public class T06_2_CopyOnWriteArrayList {

    public static void main(String[] args) throws InterruptedException {
        List<String> list1 = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 250; i++) {
            new Thread(() -> {
                list1.add(new Random().nextInt(100) + 1 + "");
                System.out.println(Thread.currentThread().getName() + "执行完毕"
                        /*+ ": " + list1*/);
            }, "线程" + i).start();
        }

        System.out.println("最终结果: " + list1);
        System.out.println("大小: " + list1.size());

    }

}
