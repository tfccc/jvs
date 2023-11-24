package pac10_GOF_Practice;

import javassist.runtime.Inner;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeUnit;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-25 09:51
 * @desc: 2.多线程模拟
 *
 * 4类5种
 *      1.饿汉式
 *      2.懒汉式1--锁方法(锁实例对象)
 *      3.懒汉式2--锁代码块(锁类模板)
 *      4.静态内部类
 *      5.枚举
 *
 **/
public class C_Singleton2 {

    public static void main(String[] args) throws InterruptedException {
        //hungry();
        //lazy1();
        //lazy2();
        //staticInner();
        enumType();
    }

    private static void hungry() throws InterruptedException {
        System.out.println("------------------hungry----------------");
        Set<Object> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 100; i++) new Thread(() -> set.add(Hungry2.getInstance())).start();
        TimeUnit.MILLISECONDS.sleep(1000);
        set.forEach(System.out::println);
        System.out.println();
    }

    private static void lazy1() throws InterruptedException {
        System.out.println("------------------lazy1-----------------");
        Set<Object> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 100; i++) new Thread(() -> set.add(Lazy2_1.getInstance())).start();
        TimeUnit.MILLISECONDS.sleep(1000);
        set.forEach(System.out::println);
        System.out.println();
    }

    private static void lazy2() throws InterruptedException {
        System.out.println("------------------lazy2-----------------");
        Set<Object> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 100; i++) new Thread(() -> set.add(Lazy2_2.getInstance())).start();
        TimeUnit.MILLISECONDS.sleep(1000);
        set.forEach(System.out::println);
        System.out.println();
    }

    private static void staticInner() throws InterruptedException {
        System.out.println("------------------inner-----------------");
        Set<Object> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 100; i++) new Thread(() -> set.add(StaticInnerClass.getInstance())).start();
        TimeUnit.MILLISECONDS.sleep(1000);
        set.forEach(System.out::println);
        System.out.println();
    }

    private static void enumType() throws InterruptedException {
        System.out.println("------------------inner-----------------");
        Set<Object> set = new CopyOnWriteArraySet<>();
        for (int i = 1; i <= 100; i++) new Thread(() -> set.add(Enum.getInstance())).start();
        TimeUnit.MILLISECONDS.sleep(1000);
        set.forEach(System.out::println);
        System.out.println();
    }

}


class Hungry2 {
    private static Hungry2 instance = new Hungry2();

    private Hungry2() {
        System.out.println(Thread.currentThread().getName() + " -- new Hungry()");
    }

    public static Hungry2 getInstance() {
        return instance;
    }
}

class Lazy2_1 {
    private static Lazy2_1 lazy;

    private Lazy2_1() {
        System.out.println(Thread.currentThread().getName() + " -- new Lazy1()");
    }

    public synchronized static Lazy2_1 getInstance() {
        if (lazy == null) {
            lazy = new Lazy2_1();
        }
        return lazy;
    }
}

class Lazy2_2 {
    private volatile static Lazy2_2 lazy;

    private Lazy2_2() {
        System.out.println(Thread.currentThread().getName() + " -- new Lazy2()");
    }

    public static Lazy2_2 getInstance() {
        if (lazy == null) {
        synchronized (Lazy2_2.class) {
            if (lazy == null) {
                lazy = new Lazy2_2();
            }
        }
    }
        return lazy;
    }
}

class StaticInnerClass {

    private StaticInnerClass() {
        System.out.println(Thread.currentThread().getName() + " -- new staticInner()");
    }

    private static class Inner {
        private static StaticInnerClass instance = new StaticInnerClass();
    }

    public static StaticInnerClass getInstance() {
        return Inner.instance;
    }
}

class Enum {
    private Enum() {
        System.out.println(Thread.currentThread().getName() + " -- new enum()");
    }

    enum InnerEnum {
        INSTANCE;

        private Enum anEnum;

        InnerEnum() {
            this.anEnum = new Enum();
        }

        private Enum getInstance() {
            return anEnum;
        }
    }

    public static Enum getInstance() {
        return InnerEnum.INSTANCE.getInstance();
    }
}