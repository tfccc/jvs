package pac05_Thread;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * @author TFC
 * @date 2019��7��19�� ����2:17:06
 * @note Timer��ʱ�����߳�(Timer �� TimerTask)
 *
 * schedule(): �����һ������ʱ, ��һ��ִ��ʱ��ȴ����õļ��
 *
 * scheduleAtFixedRate(): �����һ������ʱ, ��һ������ݼ���Ĺ���, ����ִ�л�x<���ʱ����ִ��,
 *                        �����ڲ����Ե�, ��������ԭ���ļ������
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