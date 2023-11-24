package pac05_Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author TFC
 * @date   2019年7月17日 下午2:14:49
 * @note   同步块(锁某一对象或变量)
 */
public class T18_SynchronizeBlock {
	public static void main(String[] args) throws InterruptedException {
		buyTicket b1=new buyTicket();
		new Thread(b1,"线程1").start();
		new Thread(b1,"线程2").start();
		new Thread(b1,"线程3").start();
		//syn_Var();
	}
	
	//1.锁变量
	static void syn_Var() throws InterruptedException {
		List <String> list=new ArrayList<String>();
		for (int i =0; i <2000; i++) {
			new Thread(()-> {
				//锁定list对象,拒绝其它线程访问,
				//操作完成后再解锁，进行下一次操作
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
				
			}).start();
		}
		//操作完成后打印
		Thread.sleep(100);
		System.out.println(list.size());
	}
	//1.1直接用封装好的同步类
	static void syn_Collection() throws InterruptedException {
		CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
		for (int i =0; i <2000; i++) {
			new Thread(()-> {
					list.add(Thread.currentThread().getName());		
			}).start();
		}
		//操作完成后打印
		Thread.sleep(100);
		System.out.println(list.size());
	}
}
	


class buyTicket implements Runnable{
	int ticketnum=500;
	boolean flag=true;
	//2.锁方法
	synchronized void syn_Method() {
		if(ticketnum<0) {
			flag=false;
			return;
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		System.out.println(Thread.currentThread().getName()
							+"："+ticketnum--);
	}
	
	/* 3.锁对象：方法内含有两个变量flag,tickNum,
	 *   可以通过锁this对象(buyTicket)来锁两个成员变量
	 * */
	void syn_This() {
		synchronized(this) {
			if(ticketnum<0) {
				flag=false;
				return;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { e.printStackTrace(); }
			
			System.out.println(Thread.currentThread().getName()
								+"："+ticketnum--);
			}
	}
	//4.在锁this的基础上提高性能(double checking)
	// 缩小检测范围
	void syn_This2() {
		//在外部判断是否无票，避免过多运算
		if(ticketnum<0) {
			flag=false;
			return;
		}
		synchronized(this) {
			if(ticketnum<0) {
				flag=false;
				return;
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) { e.printStackTrace(); }
			
			System.out.println(Thread.currentThread().getName()
								+"："+ticketnum--);
			}
	}
	@Override
	public void run() {
		while(flag) {
			//syn_Method();
			//syn_This();
			syn_This2();
		}
	}
}
