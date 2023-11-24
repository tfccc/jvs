package pac05_Thread;

/**
 * @author TFC
 * @date 2019��7��14�� ����7:48:49
 * @note �߳�ģ����Ʊ(ͬһ����Դʵ�ֶ������)
 */
public class T04_BuyTicket implements Runnable {
    private int ticketNum = 30;

    public static void main(String[] args) {
        T04_BuyTicket buy = new T04_BuyTicket();
        new Thread(buy, "�߳�1").start();
        new Thread(buy, "�߳�2").start();
        new Thread(buy, "�߳�3").start();

    }

    @Override
    public void run() {
        while (ticketNum >= 0) {
            try {
                //ģ����ʱ
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread()
                    .getName() + " : " + ticketNum--);
        }
    }
}
