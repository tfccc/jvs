package pac05_Thread;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author TFC
 * @date 2019年7月19日 下午2:17:06
 * @note Timer定时调度线程(Timer 、 TimerTask)
 *
 * schedule(): 如果上一个任务超时, 下一个执行时会等待设置的间隔
 *
 * scheduleAtFixedRate(): 如果上一个任务超时, 下一个会根据间隔的管理, 立即执行或x<间隔时间来执行,
 *                        类似于补偿性地, 尽力赶上原本的间隔进度
 */
public class T23_Timer {

    public static void main(String[] args) {
        Timer timer = new Timer(false);
        timer.schedule(new MyTaskTestSchedule(), 0, 1000);
        //timer.scheduleAtFixedRate(new MyTaskTestScheduleAtFixedRate(), 0, 1000);

    }

}


class MyTaskTestSchedule extends TimerTask {

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Schedule " + LocalDateTime.now());
    }

}

class MyTaskTestScheduleAtFixedRate extends TimerTask {

    @Override
    public void run() {
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ScheduleAtFixedRate " + LocalDateTime.now());
    }

}