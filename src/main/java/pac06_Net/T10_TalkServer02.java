package pac06_Net;


/**
 * @author TFC
 * @date   2019年7月24日 下午1:59:54
 * @note   本地聊天室02
 */
public class T10_TalkServer02 {
	public static void main(String[] args) throws Exception {
		System.out.println("客户端2");
		new Thread(new Send(8847, 8850)).start();
		new Thread(new Receive(8849,"用户2")).start();
	}
}
