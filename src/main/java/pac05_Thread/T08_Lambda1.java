package pac05_Thread;


/**
 * @author TFC
 * @date   2019年7月15日 上午9:59:07
 * @note   Lambda表达式,实现线程简化
 * 
 * 1.适用于(线程用一次/线程体比较简单)
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
		//jdk8 使用Lambad简化
		new Thread(()->{
				for (int i = 0; i <500; i++) {
					System.out.println("——————");
				}
			}
		).start();
	}

}
