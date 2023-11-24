package pac16_Thread_Juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-21 21:15
 * @desc:
 **/
public class T06_4_ConcurrentHashMap {

    public static void main(String[] args) throws InterruptedException {
        //Map<String, String> map = new HashMap<>();
        Map<String, String> map = new ConcurrentHashMap<>();

        for (int i = 1; i <= 100; i++) {
            int finalI = i;
            new Thread(() -> {
                map.put(
                        Thread.currentThread().getName(),
                        (finalI + "")
                );
                System.out.println(map);
            }, "Ïß³Ì" + i).start();
        }

        Thread.sleep(100);
        System.out.println("final res");
        System.out.println(map);
        System.out.println(map.size());
    }

}
