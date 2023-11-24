package pac15_Keyword;

/**
 * @author TFC
 * @date 2019��7��17�� ����12:41:44
 * @note �߳�(��������ͬ��ĳһ����)�������ȫ���� (�߳�ͬ������)
 *
 * 1.synchronized���Ա�֤�������ߴ����������ʱ��ͬһʱ��ֻ��һ����
 *   �����Խ��뵽�ٽ�����ͬʱ�������Ա�֤����������ڴ�ɼ���.
 *
 */
public class T11_Synchronized {

    public static void main(String[] args) {
        buyTicket0 b1 = new buyTicket0();
        new Thread(b1, "�߳�1").start();
        new Thread(b1, "�߳�2").start();
        new Thread(b1, "�߳�3").start();
    }

}

//��T04�����޸�
class buyTicket0 implements Runnable {
    private int ticketNum = 200;
    private boolean flag = true;

    //����synchronized�ؼ���,Ч�ʱ��,�����Ʒ���ʹ�̰߳�ȫ
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
                + "��" + ticketNum--);
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