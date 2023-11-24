package pac05_Thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author TFC
 * @date   2019��7��17�� ����2:14:49
 * @note   ͬ����(��ĳһ��������)
 */
public class T18_SynchronizeBlock {
	public static void main(String[] args) throws InterruptedException {
		buyTicket b1=new buyTicket();
		new Thread(b1,"�߳�1").start();
		new Thread(b1,"�߳�2").start();
		new Thread(b1,"�߳�3").start();
		//syn_Var();
	}
	
	//1.������
	static void syn_Var() throws InterruptedException {
		List <String> list=new ArrayList<String>();
		for (int i =0; i <2000; i++) {
			new Thread(()-> {
				//����list����,�ܾ������̷߳���,
				//������ɺ��ٽ�����������һ�β���
				synchronized (list) {
					list.add(Thread.currentThread().getName());
				}
				
			}).start();
		}
		//������ɺ��ӡ
		Thread.sleep(100);
		System.out.println(list.size());
	}
	//1.1ֱ���÷�װ�õ�ͬ����
	static void syn_Collection() throws InterruptedException {
		CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
		for (int i =0; i <2000; i++) {
			new Thread(()-> {
					list.add(Thread.currentThread().getName());		
			}).start();
		}
		//������ɺ��ӡ
		Thread.sleep(100);
		System.out.println(list.size());
	}
}
	


class buyTicket implements Runnable{
	int ticketnum=500;
	boolean flag=true;
	//2.������
	synchronized void syn_Method() {
		if(ticketnum<0) {
			flag=false;
			return;
		}
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) { e.printStackTrace(); }
		
		System.out.println(Thread.currentThread().getName()
							+"��"+ticketnum--);
	}
	
	/* 3.�����󣺷����ں�����������flag,tickNum,
	 *   ����ͨ����this����(buyTicket)����������Ա����
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
								+"��"+ticketnum--);
			}
	}
	//4.����this�Ļ������������(double checking)
	// ��С��ⷶΧ
	void syn_This2() {
		//���ⲿ�ж��Ƿ���Ʊ�������������
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
								+"��"+ticketnum--);
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
