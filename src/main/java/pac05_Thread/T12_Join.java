package pac05_Thread;

/**
 * @author TFC
 * @date 2019��7��16�� ����11:18:24
 * @note �̵߳ļ���/���
 */
public class T12_Join {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            for (int i = 1; i < 1000; i++)
                System.out.println("t1����>" + i);
        }
        );
        t1.start();
        System.out.println("t1����..............................");

        for (int i = 1; i < 1000; i++) {
            //�ȿ�ʼ����ͬʱ����
            //main��500��ʱ����t1ִ���꣬main��ִ��
            System.out.println("main->" + i);
            if (i == 500) {
                t1.join();
            }
        }

    }

}
