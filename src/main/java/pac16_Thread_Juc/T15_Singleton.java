package pac16_Thread_Juc;

import java.util.concurrent.TimeUnit;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-23 13:47
 * @desc: 单例模式
 **/
public class T15_Singleton {

    public static void main(String[] args) throws InterruptedException {
        //单线程创建不存在问题
        //singleThreadCreate();
        //多线程创建lazy会创建多例
        multiThreadCreate();
    }

    //单线程创建
    static void singleThreadCreate() {
        for (int i = 1; i <= 50; i++) {
            Lazy.getInstance();
            Hungry.getInstance();
            StaticInnerClass.getInstance();
            Enum.getInstance();
        }
    }

    //单线程创建
    static void multiThreadCreate() {

        for (int i = 1; i <= 10; i++) {
            new Thread(() -> {
                Lazy.getInstance();
                Hungry.getInstance();
                StaticInnerClass.getInstance();
                Enum.getInstance();
            }).start();
        }
    }

}


//1.饿汉式(加载时线程安全,没有延时加载)
class Hungry {

    private Hungry() {
        System.out.println(Thread.currentThread().getName() +
                " -- new hungry");
    }

    private final static Hungry hungry = new Hungry();

    public static Hungry getInstance() {
        return hungry;
    }
}

//2.懒汉式
class Lazy {
    private Lazy() {
        System.out.println(Thread.currentThread().getName() +
                " -- new lazy");
    }

    /**
     * 防止构造对象发生指令重排(如果顺序123变为132则会出问题)
     * 1.分配内存
     * 2.执行构造方法
     * 3.对象指向该空间
     */
    private volatile static Lazy lazy;

    //DCL(double checked locking): 锁代码块,双重监测
    public static Lazy getInstance() {
        if (lazy == null) {
            synchronized (Lazy.class) {
                if (lazy == null) {
                    lazy = new Lazy();
                }
            }
        }
        return lazy;
    }
}


//3.静态内部类
class StaticInnerClass {

    private StaticInnerClass() {
        System.out.println(Thread.currentThread().getName() +
                " -- new staticInnerClass");
    }

    public static StaticInnerClass getInstance() {
        return Inner.instance;
    }

    public static class Inner {

        private Inner() {
            System.out.println(Thread.currentThread().getName() +
                    " -- new Inner");
        }

        private static final StaticInnerClass instance = new StaticInnerClass();
    }
}


//4.枚举(最安全, 无法通过反射破解)
class Enum {
    //私有化构造函数
    private Enum() {
    }

    //定义一个内部枚举类
    enum SingletonEnum {
        //创建一个枚举对象，该对象天生为单例
        INSTANCE;

        private Enum anEnum;
        //枚举的构造函数(默认为私有)
        SingletonEnum() {
            anEnum = new Enum();
            System.out.println(Thread.currentThread().getName() +
                    " -- new enum");
        }

        public Enum getInstance() {
            return anEnum;
        }
    }

    //对外暴露一个获取User对象的静态方法
    public static Enum getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }
}

