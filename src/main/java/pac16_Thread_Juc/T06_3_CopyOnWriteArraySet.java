package pac16_Thread_Juc;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-21 20:54
 * @desc:
 **/
public class T06_3_CopyOnWriteArraySet {

    public static void main(String[] args) {
        Set<String> set = new CopyOnWriteArraySet<>();

        for (int i = 1; i <= 250; i++) {
            new Thread(() -> {
                set.add(new Random().nextInt(100) + 1 + "");
                System.out.println(Thread.currentThread().getName() + "ִ�����"
                        /*+ ": " + list1*/);
            }, "�߳�" + i).start();
        }

        System.out.println("���ս��: " + set);
        System.out.println("��С: " + set.size());

    }
}
