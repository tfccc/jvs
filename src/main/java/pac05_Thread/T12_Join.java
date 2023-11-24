package pac05_Thread;

/**
 * @author TFC
 * @date 2019年7月16日 上午11:18:24
 * @note 线程的加入/插队
 */
public class T12_Join {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 1000; i++)
                System.out.println("t1——>" + i);
        }
        );
        t1.start();
        System.out.println("t1启动..............................");

        for (int i = 1; i < 1000; i++) {
            //先开始两者同时进行
            //main到500次时，让t1执行完，main再执行
            System.out.println("main->" + i);
            if (i == 500) {
                t1.join();
            }
        }

    }

}
