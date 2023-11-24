package pac16_Thread_Juc;

import java.util.concurrent.*;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-22 10:07
 * @desc:
 *
 * * 需用FutureTask转换后执行
 *
 * Runnable的区别:
 *      1.有返回值
 *      2.可抛出异常
 *      3.方法名不同
 *
 **/
public class T07_Callable {


    private static void test() {
        FutureTask<Object> task = new FutureTask<>(new Callable1());

        new Thread(task, "a").start();
        //第二个结果会被缓存
        new Thread(task, "b").start();


        //get可能会产生阻塞(需放在最后, 或用异步通信)
        Object o = null;
        try {
            o = task.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(o);
    }

}

class Callable1 implements Callable<Object> {

    @Override
    public Object call() {
        System.out.println("body: call");
        return "return: tfc";
    }
}