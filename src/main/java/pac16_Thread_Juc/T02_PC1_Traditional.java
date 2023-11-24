package pac16_Thread_Juc;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-20 21:16
 * @desc: 生消1: 传统版本
 *
 * 步骤:
 *      1.判断是否等待
 *      2.处理
 *      3.通知
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

    //生产
    public synchronized void produce() {
        //1.判断是否等待
        while (number != 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2.处理
        number++;
        System.out.println(Thread.currentThread().getName() + "生产: " + number);
        //3.通知
        this.notifyAll();
    }

    //消费
    public synchronized void consume() {
        //1.判断是否等待
        while (number == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //2.处理
        number--;
        System.out.println(Thread.currentThread().getName() + "消费: " + number);
        //3.通知
        this.notifyAll();
    }

}
