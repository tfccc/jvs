package pac05_Thread;

import java.util.List;
import java.util.ArrayList;

/**
 * @author TFC
 * @date   2019��7��17�� ����12:18:41
 * @note   �̲߳����İ�ȫ(��Ʊ)
 * 
 * 1.��ȫ:������ȷ��Ч�ʾ����ܸ�
 * 2.����ȫ:���ݲ���ȷ�򳬳���Χ
 * 3.����:ͬһ�����󱻶���߳�ͬʱ����
 * 
 */
public class T16_Safety {
	public static void main(String[] args) {
		unsafe1_buyTicket();
		//unsafe2_addThreadToList();
	}
	
	//�龰1:���ָ���/һƱ���������
	private static void unsafe1_buyTicket() {
		T04_BuyTicket by=new T04_BuyTicket();
		new Thread(by,"�߳�1").start();
		new Thread(by,"�߳�2").start();
		new Thread(by,"�߳�3").start();
	}
	//�龰2:�����߳�δ����
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
