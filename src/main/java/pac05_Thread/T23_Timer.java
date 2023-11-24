package pac05_Thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author TFC
 * @date   2019年7月19日 下午2:17:06
 * @note   Timer定时调度线程(Timer、TimerTask)
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