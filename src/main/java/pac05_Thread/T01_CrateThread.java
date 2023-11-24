package pac05_Thread;

/**
 * @author TFC
 * @date 2019年7月14日 下午2:46:03
 * @note 创建线程
 *
 * 创建方法：
 *	 1.继承Thread类,重写run()
 *	 2.实现Runnable接口,重写run()
 *	 3.实现Callable接口,重写call()
 *
 */
public class T01_CrateThread extends Thread {

    @Override
    public void run() {
        System.out.println("运行线程: " + this.getName());
        for (int i = 0; i < 500; i++) {
            System.out.println("———————");
        }
    }

    public static void main(String[] args) {
        //创建子类对象,调用子类对象的start(),创建两条运行路径(main/st)
        T01_CrateThread st = new T01_CrateThread();
        st.setName("线程2: 继承Thread实现");

        //调用上面重写的run(),实现线程的创建
        st.start();
        for (int i = 0; i < 500; i++) {
            System.out.println("****");
        }
    }
}
