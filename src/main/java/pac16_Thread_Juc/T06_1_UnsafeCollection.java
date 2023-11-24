package pac16_Thread_Juc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-21 19:41
 * @desc: 多线程下, 容器的不安全性 (单线程是安全的)
 **/
public class T06_1_UnsafeCollection {

    public static void main(String[] args) throws InterruptedException {
        List<String> list1 = new ArrayList<>(1000);

        for (int i = 1; i <= 100; i++) {
            list1.add(new Random().nextInt(90) + 10 + "");

            String s = list1.get(i-1);
        }

        //TimeUnit.SECONDS.sleep(1);
        System.out.println("最终结果: " + list1);
        System.out.println("大小: " + list1.size());
    }

}
