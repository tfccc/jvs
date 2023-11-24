package pac05_Thread;

/**
 * @author TFC
 * @date   2019年7月14日 下午7:32:16
 * @note   使用Runnable接口启动线程(避免继承的局限性)
 * 
 *   使用方法：
 * 1.Runnable接口+重写run()
 * 2.方法1：实现类对象+Thread代理对象+start()
 * 3.方法2：使用匿名类启动(当对象只需要调用一次时)
 */
public class T03_Runnable implements Runnable{

	public static void main(String[] args) {
		/*方法1：使用代理对象启动*/
		/*//创建需要实现的对象
		T03_Runnable t=new T03_Runnable();
		//创建代理对象
		Thread th=new Thread(t);
		//启动代理对象
		th.start();*/
		
		/*方法2：使用匿名类启动(当对象只需要调用一次时)*/
		new Thread(new T03_Runnable()).start();
		for (int i = 0; i <500; i++) {
			System.out.println("***");
		}
	}

	@Override
	public void run() {
		for (int i = 0; i <500; i++) {
			System.out.println("——————");
		}
	}

}
