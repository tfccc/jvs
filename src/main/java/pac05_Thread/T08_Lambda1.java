package pac05_Thread;


/**
 * @author TFC
 * @date   2019��7��15�� ����9:59:07
 * @note   Lambda���ʽ,ʵ���̼߳�
 * 
 * 1.������(�߳���һ��/�߳���Ƚϼ�)
 * 
 */
public class T08_Lambda1 {
	public static void main(String[] args) {
		
		lambda();
		
		for (int i = 0; i <500; i++) {
			System.out.println("***");
		}
	}
	
	private static void lambda(){
		//jdk8 ʹ��Lambad��
		new Thread(()->{
				for (int i = 0; i <500; i++) {
					System.out.println("������������");
				}
			}
		).start();
	}

}
