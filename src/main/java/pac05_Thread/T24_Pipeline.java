package pac05_Thread;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-07-23 09:27
 * @desc: 管程法
 *
 * 角色:
 *      1.生产者: 生产产品
 *      2.消费者: 消费产品
 *      3.管道/缓冲区: 存放生产者的产品, 供消费者消费
 *      4.产品: 生产者生产的产品
 *
 **/
public class T24_Pipeline {

    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Thread(new Producer2(container)).start();
        new Thread(new Consumer2(container), "C1").start();
        //new Thread(new Consumer2(container), "C2").start();

    }
}

//生产者
class Producer2 implements Runnable {
    SynContainer container;

    public Producer2(SynContainer container) {
        this.container = container;
    }

    //生产产品
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产产品: " + i);
            container.pushIn(new Product2(i));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//消费者
class Consumer2 implements Runnable {

    SynContainer container;

    public Consumer2(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() +
                    "------------->" + container.popOut().getId());
        }
    }
}

//管道(缓冲区)
class SynContainer {
    Product2[] products = new Product2[100];
    private int c;

    //产品放入管道
    public synchronized void pushIn(Product2 product) {
        if (c == products.length) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        products[c++] = product;
        this.notifyAll();
    }

    //拿取产品
    public synchronized Product2 popOut() {
        if (c == 0) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();
        return products[--c];
    }

}

//产品(资源)
class Product2 {
    private int id;

    public Product2(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}