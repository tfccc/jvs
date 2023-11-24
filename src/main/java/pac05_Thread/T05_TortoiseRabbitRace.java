package pac05_Thread;

/**
 * @author TFC
 * @date 2019��7��14�� ����8:09:22
 * @note �߳�ģ���������
 */
public class T05_TortoiseRabbitRace implements Runnable {
    private static String winner;
    private static final int END_STEP = 300;
    private boolean haveWinner;
    private int step;

    public static void main(String[] args) {
        T05_TortoiseRabbitRace racer = new T05_TortoiseRabbitRace();
        new Thread(racer, "����").start();
        new Thread(racer, "�ڹ�").start();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        long sleepTime = name.equals("����") ? 20: 25;
        int speed = name.equals("����") ? 2 : 1;

        try {
            move(name, sleepTime, speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private boolean gameOver() {
        //����Ѳ���ʤ��
        if (winner != null)
            return true;
            //��ɲ���,����ʤ��
        else {
            if (step >= END_STEP) {
                winner = Thread.currentThread().getName();
                System.out.println(winner + "Ӯ�˱�����");
                return true;
            }
        }
        return false;
    }

    private void move(String name, long sleepTime, int speed) throws InterruptedException {
        while (true){
            if (gameOver()) {
                break;
            }
            System.out.println(name + "-->" + this.step);
            this.step += speed;
            Thread.sleep(sleepTime);
        }

    }

}
