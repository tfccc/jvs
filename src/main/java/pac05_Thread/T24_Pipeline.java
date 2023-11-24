package pac05_Thread;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-07-23 09:27
 * @desc: �̷ܳ�
 *
 * ��ɫ:
 *      1.������: ������Ʒ
 *      2.������: ���Ѳ�Ʒ
 *      3.�ܵ�/������: ��������ߵĲ�Ʒ, ������������
 *      4.��Ʒ: �����������Ĳ�Ʒ
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

//������
class Producer2 implements Runnable {
    SynContainer container;

    public Producer2(SynContainer container) {
        this.container = container;
    }

    //������Ʒ
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("������Ʒ: " + i);
            container.pushIn(new Product2(i));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

//������
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

//�ܵ�(������)
class SynContainer {
    Product2[] products = new Product2[100];
    private int c;

    //��Ʒ����ܵ�
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

    //��ȡ��Ʒ
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

//��Ʒ(��Դ)
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