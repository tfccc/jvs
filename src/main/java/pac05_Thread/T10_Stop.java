package pac05_Thread;

/**
 * @author TFC
 * @date   2019年7月16日 上午10:21:31
 * @note   线程终止
 * 
 * 终止方法：
 *	 1.线程正常执行完
 *	 2.通过外部的标识变量来终止线程
 * 
 */
public class T10_Stop implements Runnable{
	private static boolean flag=true;
	private String name;
	public T10_Stop(String name) {
		this.name=name;
	}
	
	@Override
	public void run() {
		int i=0;
		while(flag) {
			System.out.println(name+":"+(i++));
		}
	}

	public static void main(String[] args) {
		new Thread(new T10_Stop("thread")).start();
		
		for(int i=0;i<=100;i++) {
			//终止条件：当main线程运行90次
			if(i==90) {
				flag=false; 
				System.out.println("OVER..............");
			}
			System.out.println("main:"+i);
		}
	}

}
