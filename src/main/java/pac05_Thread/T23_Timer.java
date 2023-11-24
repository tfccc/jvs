package pac05_Thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author TFC
 * @date   2019��7��19�� ����2:17:06
 * @note   Timer��ʱ�����߳�(Timer��TimerTask)
 */
public class T23_Timer {

	public static void main(String[] args) {
		Timer timer =new Timer();
		timer.schedule(new TaskTest(), 1000,500);
	}

}
class TaskTest extends TimerTask{

	@Override
	public void run() {
		System.out.println("Hello World");
	}
	
}