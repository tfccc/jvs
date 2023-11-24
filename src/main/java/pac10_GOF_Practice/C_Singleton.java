package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-05 14:22
 * @note: 单例模式
 **/
public class C_Singleton {
    public static void main(String[] args) {
        //1.饿汉式
        Hungry hungry = Hungry.getInstance();
        System.out.println(hungry.description);

        //2.懒汉式
        Lazy lazy = Lazy.getInstance();
        System.out.println(lazy.description);

        //3.静态内部类式
        StaticInner inner = StaticInner.getInstance();
        System.out.println(inner.description);
    }
}

/**
 * 1.饿汉式
 */
class Hungry {
    String description = "1.饿汉式:初始化类立即加载实例;效率高;线程不安全;";
    private static Hungry instance = new Hungry(); //直接吃

    public static Hungry getInstance() {
        return instance;
    }
}

/**
 * 2.懒汉式
 */
class Lazy {
    String description = "2.懒汉式:有则不加载,无则加载对;象效率低;线程安全;实现延迟加载";
    private static Lazy instance;

    public static synchronized Lazy getInstance() {
        if (instance == null)       //饿
            instance = new Lazy();  //吃
        return instance;
    }
}

/**
 * 3.静态内部类式
 */
class StaticInner {
    String description = "3.静态内部类式:综合懒饿优点;效率高;线程安全;实现延迟加载";

    private static class InnerClass {
        //将类的实例化放到静态内部类里,这种形式天生线程安全,且效率高
        private static final StaticInner instance = new StaticInner();
    }

    public static StaticInner getInstance() {
        return InnerClass.instance;
    }
}
