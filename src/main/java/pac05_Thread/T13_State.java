package pac05_Thread;

import java.lang.Thread.State;

/**
 * @author TFC
 * @date   2019年7月16日 上午11:35:18
 * @note   线程状态的观察
 *
 * 状态分类:
 * 1.NEW
 * 2.RUNNABLE
 * 3.BLOCKED
 * 4.WAITING (无限等)
 * 5.TIMED_WAITING (有限等)
 * 6.TERMINATED
 *
 */
public class T13_State {
	public static void main(String[] args) {
		State st=null;
		Thread t1=new Thread(()->{
			System.out.println("");
		}
		);
		//新生状态
		System.out.println(t1.getState());

		//运行/就绪状态
		t1.start();
		System.out.println(t1.getState());
		while(t1.getState()!=Thread.State.TERMINATED) {

		}

		//死亡状态
		System.out.println(t1.getState());
	}
}
