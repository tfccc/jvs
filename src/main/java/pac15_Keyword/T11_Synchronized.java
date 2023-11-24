package pac15_Keyword;

/**
 * @author TFC
 * @date 2019年7月17日 下午12:41:44
 * @note 线程(用锁机制同步某一方法)解决不安全问题 (线程同步操作)
 *
 * 1.synchronized可以保证方法或者代码块在运行时，同一时刻只有一个方
 *   法可以进入到临界区，同时它还可以保证共享变量的内存可见性.
 *
 */
public class T11_Synchronized {

    public static void main(String[] args) {
        buyTicket0 b1 = new buyTicket0();
        new Thread(b1, "线程1").start();
        new Thread(b1, "线程2").start();
        new Thread(b1, "线程3").start();
    }

}

//对T04进行修改
class buyTicket0 implements Runnable {
    private int ticketNum = 200;
    private boolean flag = true;

    //加入synchronized关键字,效率变低,但控制访问使线程安全
    private synchronized void syn_Method() {
        if (ticketNum < 0) {
            flag = false;
            return;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()
                + "：" + ticketNum--);
    }

    @Override
    public void run() {
        long a = System.currentTimeMillis();
        while (flag) {
            syn_Method();
        }
        long b = System.currentTimeMillis();
        System.out.println(b - a);
    }
}