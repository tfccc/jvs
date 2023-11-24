package pac05_Thread;

/**
 * @author TFC
 * @date   2019年7月17日 下午12:04:32
 * @note   守护线程
 * 
 * 1.线程默认是用户线程
 * 2.jvm等用户线程执行完就停止
 * 
 */
public class T15_Daemon {

	public static void main(String[] args) {
		//用户线程
		Thread t1=new Thread(()-> {
			for(int i=1;i<=365;i++)
				System.out.println("main:"+i);
			}
		);
		//守护线程
		Thread t2=new Thread(()-> {
			int i=0;
			while(true)
				System.out.println("daemon:"+(++i));
			}
		);
		//设置守护线程
		t2.setDaemon(true);
		t1.start();t2.start();
	}
}
