package pac05_Thread;

/**
 * @author TFC
 * @date   2019年7月16日 上午10:47:23
 * @note   礼让(运行状态,转入就绪状态)
 */
public class T11_Yield{
	public static void main(String[] args) {
		Yield y1=new Yield();
		Yield y2=new Yield();
		new Thread(y1,"A").start();
		new Thread(y2,"B").start();
		
	}

}
class Yield implements Runnable{

	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName()+"——>start");
		Thread.yield();
		System.out.println(Thread.currentThread().getName()+"——>end..");
	}
	
}