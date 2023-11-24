package pac05_Thread;

/**
 * @author TFC
 * @date 2019年7月14日 下午8:09:22
 * @note 线程模拟龟兔赛跑
 */
public class T05_TortoiseRabbitRace implements Runnable {
    private static String winner;
    private static final int END_STEP = 300;
    private boolean haveWinner;
    private int step;

    public static void main(String[] args) {
        T05_TortoiseRabbitRace racer = new T05_TortoiseRabbitRace();
        new Thread(racer, "兔子").start();
        new Thread(racer, "乌龟").start();
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        long sleepTime = name.equals("兔子") ? 20: 25;
        int speed = name.equals("兔子") ? 2 : 1;

        try {
            move(name, sleepTime, speed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private boolean gameOver() {
        //如果已产生胜者
        if (winner != null)
            return true;
            //完成步数,产生胜者
        else {
            if (step >= END_STEP) {
                winner = Thread.currentThread().getName();
                System.out.println(winner + "赢了比赛！");
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
