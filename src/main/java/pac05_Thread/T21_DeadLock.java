package pac05_Thread;

/**
 * @author TFC
 * @date 2019年7月19日 上午11:11:26
 * @note 死锁(线程执行不当 ， 相互不释放资源 ， 从而相互等待)
 *
 *  避免:不要在同一个代码块中，同时持有对个对象的锁
 */
public class T21_DeadLock {

    public static String obj1 = "obj1";
    public static String obj2 = "obj2";


    public static void main(String[] args) {
        lock();
    }


    //死锁情况:a,b线程同时竞争资源，发生相互等待
    static void lock() {
        Thread a = new Thread(new Lock1());
        Thread b = new Thread(new Lock2());
        a.start();
        b.start();
    }

    //解除死锁
    static void nolock() {
        //1.去掉下面代码内嵌的syn语句
        //2.去掉其中一个线程，无竞争
    }
}

class Lock1 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("线程1  running");
            while (true) {
                synchronized (T21_DeadLock.obj1) {
                    System.out.println("线程1  锁定  obj1");
                    Thread.sleep(1000);//获取obj1后先等一会儿，让Lock2有足够的时间锁住obj2
                    synchronized (T21_DeadLock.obj2) {
                        System.out.println("线程1  锁定  obj2");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class Lock2 implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("线程2  running");
            while (true) {
                synchronized (T21_DeadLock.obj2) {
                    System.out.println("线程2  锁定  obj2");
                    Thread.sleep(1000);
                    synchronized (T21_DeadLock.obj1) {
                        System.out.println("线程2  锁定  obj1");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}