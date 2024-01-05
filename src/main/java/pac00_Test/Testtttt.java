package pac00_Test;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Frank.Tang
 * @date 2023-03-25 14:28
 * @desc
 **/
public class Testtttt {


    private static AtomicLong main = new AtomicLong(0);
    private static AtomicLong mt = new AtomicLong(0);

    private static final int THREAD_NUM = 4;
    private static CountDownLatch latch1 = new CountDownLatch(THREAD_NUM);
    private static CountDownLatch latch0 = new CountDownLatch(THREAD_NUM);


    public static void main(String[] args) {
        Testtttt test = new Testtttt();
        test.override();
    }

    public void override() {

        List<Object> list1 = new ArrayList<>() {
            @Override
            public boolean add(Object o) {
                return super.add(o);
            }
        };

        List<Object> list2 = new ArrayList<>();

        System.out.println("list1.class: " + list1.getClass());
        System.out.println("list1.super: " + list1.getClass().getSuperclass());
        System.out.println("list2.class: " + list2.getClass());
    }

    static String lock = "1";

    private static void test() {
        synchronized (lock) {
            System.out.println(lock);
        }
    }


}
