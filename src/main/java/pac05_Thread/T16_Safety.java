package pac05_Thread;

import java.util.List;
import java.util.ArrayList;

/**
 * @author TFC
 * @date   2019年7月17日 下午12:18:41
 * @note   线程并发的安全(火车票)
 * 
 * 1.安全:数据正确，效率尽可能高
 * 2.不安全:数据不正确或超出范围
 * 3.并发:同一个对象被多个线程同时操作
 * 
 */
public class T16_Safety {
	public static void main(String[] args) {
		unsafe1_buyTicket();
		//unsafe2_addThreadToList();
	}
	
	//情景1:出现负数/一票多抢的情况
	private static void unsafe1_buyTicket() {
		T04_BuyTicket by=new T04_BuyTicket();
		new Thread(by,"线程1").start();
		new Thread(by,"线程2").start();
		new Thread(by,"线程3").start();
	}
	//情景2:部分线程未加入
	private static void unsafe2_addThreadToList() {
		List<String> l=new ArrayList<>();
		for (int i =0; i <1000; i++) {
			new Thread(()-> {
				l.add(Thread.currentThread().getName());
			}).start();
		}	
		System.out.println(l.size());
	}
}
