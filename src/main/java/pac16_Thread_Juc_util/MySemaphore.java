package pac16_Thread_Juc_util;

import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author Frank.Tang
 * @date 2023-03-28 11:35
 * @desc �ź���ʵս
 **/
public class MySemaphore {

    private static final Random RANDOM = new Random();


    public static void main(String[] args) {
        //parkingLotDemo1();
        //parkingLotDemo2();

        try {
            System.out.println("try");
            System.exit(1);
            Runtime.getRuntime().exit(1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("catch");
        } finally {
            System.out.println("finally");
        }
    }


    /**
     * ʹ��Semaphoreģ��ͣ����ͣ������ (һ��һλ)
     * @author Frank.Tang
     */
    private static void parkingLotDemo1() {
        //ͣ����, ӵ��n��ͣ��λ
        Semaphore semaphore = new Semaphore(4);

        //n����, ��Ҫ��ȥͣ��
        for (int i = 1; i <= 10; i++) {
            final String carName = "car" + i;

            //ͣ��ʱ��
            int parkTime = RANDOM.nextInt(1001) + 5000;

            new Thread(() -> {
                try {
                    //���복λ
                    System.out.println(carName + "--���복λ");
                    semaphore.acquire();

                    //��ʼͣ��
                    System.out.println(carName + "--��ʼͣ��, ͣ��ʱ��=" + parkTime);
                    TimeUnit.MILLISECONDS.sleep(parkTime);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    //ͣ������
                    semaphore.release();
                    System.out.println(carName + "--ͣ������");
                }
            }, carName).start();
        }
    }

    /**
     * ʹ��Semaphoreģ��ͣ����ͣ������ (һ����λ)
     * @author Frank.Tang
     */
    private static void parkingLotDemo2() {
        //ͣ����, ӵ��ʮ��ͣ��λ
        Semaphore semaphore = new Semaphore(5);

        //һ��ռ�����λ, һ�λ�ȡn���ͺ���/һ���ͷ�n���ź���
        int carSize = 2;

        //20����, ��Ҫ��ȥͣ��
        for (int i = 1; i <= 10; i++) {
            final String carName = "car" + i;

            //ͣ��ʱ��
            int parkTime = RANDOM.nextInt(1001) + 5000;

            new Thread(() -> {
                //ͣ��
                try {
                    //���복λ
                    System.out.println(carName + "--���복λ");

                    boolean acquireSuccess = semaphore.tryAcquire(carSize, 3000, TimeUnit.MILLISECONDS);

                    //��һ��ʱ�仹û��λ
                    if (!acquireSuccess) {
                        throw new RuntimeException();
                    }

                    //��ʼͣ��
                    System.out.println(carName + "--��ʼͣ��, ͣ��ʱ��=" + parkTime);
                    TimeUnit.MILLISECONDS.sleep(parkTime);

                    //ͣ������
                    semaphore.release(carSize);
                    System.out.println(carName + "--ͣ������");

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (RuntimeException e) {
                    System.out.println(carName + "--�ȴ�����, �뿪ͣ����");
                    e.printStackTrace();
                }
            }, carName).start();
        }

    }

}
