package pac05_Thread;

/**
 * @author TFC
 * @date   2019��7��14�� ����7:32:16
 * @note   ʹ��Runnable�ӿ������߳�(����̳еľ�����)
 * 
 *   ʹ�÷�����
 * 1.Runnable�ӿ�+��дrun()
 * 2.����1��ʵ�������+Thread�������+start()
 * 3.����2��ʹ������������(������ֻ��Ҫ����һ��ʱ)
 */
public class T03_Runnable implements Runnable{

	public static void main(String[] args) {
		/*����1��ʹ�ô����������*/
		/*//������Ҫʵ�ֵĶ���
		T03_Runnable t=new T03_Runnable();
		//�����������
		Thread th=new Thread(t);
		//�����������
		th.start();*/
		
		/*����2��ʹ������������(������ֻ��Ҫ����һ��ʱ)*/
		new Thread(new T03_Runnable()).start();
		for (int i = 0; i <500; i++) {
			System.out.println("***");
		}
	}

	@Override
	public void run() {
		for (int i = 0; i <500; i++) {
			System.out.println("������������");
		}
	}

}
