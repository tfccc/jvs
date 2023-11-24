package pac16_Thread_Juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-23 10:49
 * @desc: 线程的异步调用
 *
 * 1.异步执行
 * 2.成功回调
 * 3.失败回调
 *
 **/
public class T13_AsynchronousCall {

    public static void main(String[] args) throws Exception {
        test1();
        System.out.println("--------------------------");
        test2();
        System.out.println("--------------------------");
        test3();
    }

    /**
     * @desc 1.异步调用, 不返回
     */
    private static void test1() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> cf = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-- done");
        });
        System.out.println(Thread.currentThread().getName() + "--main()");
        // 调用get线程才会执行
        System.out.println(cf.get());
    }


    /**
     * @desc 2.异步调用, 返回
     */
    private static void test2() throws ExecutionException, InterruptedException {
        CompletableFuture<Object> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-- done");
            return 200;
        });
        // 调用get线程才会执行
        System.out.println(cf.get());
    }


    /**
     * @desc 3.异步调用, 返回, 具体处理结果
     */
    private static void test3() throws ExecutionException, InterruptedException {
        CompletableFuture<Object> cf = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "-- done");
            int a = 1 / 0;
            return 200;
        });
        System.out.println(
                cf.whenComplete((returnValue, errorMessage) -> {
                    System.out.println("return: " + returnValue);
                    System.out.println("message: " + errorMessage);
                }).exceptionally((e) -> 404).get()
        );
    }
}
