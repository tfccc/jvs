package pac16_Thread_Juc;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-20 21:16
 * @desc: ����1: ��ͳ�汾
 *
 * ����:
 *      1.�ж��Ƿ�ȴ�
 *      2.����
 *      3.֪ͨ
 *
 **/
public class T02_PC1_Traditional {

    static int lr = 100;

    public static void main(String[] args) {
        Product1 product = new Product1();

        new Thread(() -> {
            for (int i = 0; i <lr; i++) {
                product.produce();
            }
        }, "P1").start();

        new Thread(() -> {
            for (int i = 0; i <lr; i++) {
                product.produce();
            }
        }, "P22").start();

        new Thread(() -> {
            for (int i = 0; i < lr; i++) {
                product.consume();
            }
        }, "C1").start();

        new Thread(() -> {
            for (int i = 0; i < lr; i++) {
                product.consume();
            }
        }, "C22").start();

    }

}

class Product1 {
    private int number = 0;

    //����
    public synchronized void produce() {
        //1.�ж��Ƿ�ȴ�
        while (number != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2.����
        number++;
        System.out.println(Thread.currentThread().getName() + "����: " + number);
        //3.֪ͨ
        this.notifyAll();
    }

    //����
    public synchronized void consume() {
        //1.�ж��Ƿ�ȴ�
        while (number == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2.����
        number--;
        System.out.println(Thread.currentThread().getName() + "����: " + number);
        //3.֪ͨ
        this.notifyAll();
    }

}
