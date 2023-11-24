package pac02_Advance;

import java.util.concurrent.TimeUnit;

/**
 * @author Frank.Tang
 * @date 2023-04-11 13:21
 * @desc
 **/
public class T16_ThreadLocal {

    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        local.set("main");

        new Thread(() -> {
            local.set("t1");
            System.out.println("t1.get: " + local.get());
        }, "t1").start();

        new Thread(() -> {
            local.set("t2");
            System.out.println("t2.get: " + local.get());
            local.remove();
        }, "t2").start();

        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main.get: " + local.get());
    }

}
