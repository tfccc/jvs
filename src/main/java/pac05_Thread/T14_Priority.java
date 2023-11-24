package pac05_Thread;

/**
 * @author TFC
 * @date   2019��7��16�� ����11:49:39
 * @note   �߳����ȼ�
 * 
 * ���ȼ��󲢲���������(���ȼ�����ִ�и���Խ��)
 * 
 * 1.NORM_PRIORITY	5(Ĭ�����ȼ�)	
 * 2.MIN_PRIORITY	1	
 * 3.MAX_PRIORITY	10
 * 
 */
public class T14_Priority {
	public static void main(String[] args) {
		Thread t1=new Thread(()->{ System.out.println("Thread1");} );
		Thread t2=new Thread(()->{ System.out.println("Thread2");} );
		Thread t3=new Thread(()->{ System.out.println("Thread3");} );
		Thread t4=new Thread(()->{ System.out.println("Thread4");} );
		
		t1.setPriority(1);
		t2.setPriority(1);
		t3.setPriority(1);
		t4.setPriority(10);
		System.out.println(t4.getPriority());
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
	}
}
