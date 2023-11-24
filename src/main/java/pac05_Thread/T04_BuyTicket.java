package pac05_Thread;

/**
 * @author TFC
 * @date 2019年7月14日 下午7:48:49
 * @note 线程模拟抢票(同一个资源实现多个代理)
 */
public class T04_BuyTicket implements Runnable {
    private int ticketNum = 30;

    public static void main(String[] args) {
        T04_BuyTicket buy = new T04_BuyTicket();
        new Thread(buy, "线程1").start();
        new Thread(buy, "线程2").start();
        new Thread(buy, "线程3").start();

    }

    @Override
    public void run() {
        while (ticketNum >= 0) {
            try {
                //模拟延时
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()
                    .getName() + " : " + ticketNum--);
        }
    }
}
