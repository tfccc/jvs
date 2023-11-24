package pac09_GOF;

/**
 * @author TFC
 * @date 2019年8月13日 下午8:05:05
 * @note 单例模式
 *
 * *1.保证一个类只有一个实例，且提供一个访问该实例的全局访问点
 *
 * 模式分类:
 * 1.饿汉式
 * 2.懒汉式
 * 3.静态内部类式
 * 4.枚举式
 *
 * 实际应用：
 * 1.windows任务管理器
 * 2.回收站
 * 3.网站计数器
 */

public class T01_Singleton {
    public static void main(String[] args) {

    }
}

/**1.饿汉式**/
class Hungry {
    //类初始化时立即加载对象(加载时线程安全,没有延时加载)
    private static Hungry instance = new Hungry();

    private Hungry() {
    }

    //方法没有同步,调用效率高
    public static Hungry getInstance() {
        return instance;
    }
}

/**2.懒汉式**/
class Lazy {
    private volatile static Lazy instance;

    private Lazy() {
    }

    //方法需要同步,防止同时调用,效率低
    public static synchronized Lazy getInstance() {
        if (instance == null) {
        	instance = new Lazy();
		}
        return instance;
    }
}

/**3.静态内部类(综合1.2的优点：线程安全,调用效率高,实现了延迟加载)**/
class StaticInner {
    private static class Inner {
        private static final StaticInner instance = new StaticInner();
    }

    private StaticInner() {
    }

    public static StaticInner getInstance() {
        return Inner.instance;
    }
}

/**4.枚举式*/
enum Enum {
    INSTANCE;

    //针对枚举元素进行操作
    public void operation() {
    }
}
