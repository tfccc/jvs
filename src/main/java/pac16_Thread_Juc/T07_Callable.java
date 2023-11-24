package pac16_Thread_Juc;

import java.util.concurrent.*;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-22 10:07
 * @desc:
 *
 * * ����FutureTaskת����ִ��
 *
 * Runnable������:
 *      1.�з���ֵ
 *      2.���׳��쳣
 *      3.��������ͬ
 *
 **/
public class T07_Callable {


    private static void test() {
        FutureTask<Object> task = new FutureTask<>(new Callable1());

        new Thread(task, "a").start();
        //�ڶ�������ᱻ����
        new Thread(task, "b").start();


        //get���ܻ��������(��������, �����첽ͨ��)
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