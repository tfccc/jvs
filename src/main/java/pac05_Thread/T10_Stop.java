package pac05_Thread;

/**
 * @author TFC
 * @date   2019��7��16�� ����10:21:31
 * @note   �߳���ֹ
 * 
 * ��ֹ������
 *	 1.�߳�����ִ����
 *	 2.ͨ���ⲿ�ı�ʶ��������ֹ�߳�
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
			//��ֹ��������main�߳�����90��
			if(i==90) {
				flag=false; 
				System.out.println("OVER..............");
			}
			System.out.println("main:"+i);
		}
	}

}
