package pac06_Net;


/**
 * @author TFC
 * @date   2019��7��24�� ����1:59:54
 * @note   ����������02
 */
public class T10_TalkServer02 {
	public static void main(String[] args) throws Exception {
		System.out.println("�ͻ���2");
		new Thread(new Send(8847, 8850)).start();
		new Thread(new Receive(8849,"�û�2")).start();
	}
}
