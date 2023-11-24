package pac05_Thread;

/**
 * @author TFC
 * @date 2019��7��19�� ����12:58:06
 * @note �߳�ͬ����"������������ģʽ"
 *
 * 1.�̷ܳ�   pipeline()   //�ȴ�������
 * 2.�źŵƷ� signalLamp() //true��false�ж�
 *
 */
public class T22_BoundedBuffer {
    public static void main(String[] args) {
        //1.�̷ܳ�
        pipeline();
    }

    private static void pipeline() {
        Container container = new Container();
        Producer pro = new Producer(container);
        Consumer con = new Consumer(container);
        new Thread(pro, "������").start();
        new Thread(con, "������").start();
    }
}

//������
class Producer implements Runnable {
    private Container con;

    public Producer(Container con) {
        this.con = con;
    }

    @Override
	//����
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println("�� ������> " + i);
            //�����Ĳ�Ʒ���뻺����
            con.push(new Product(i));
        }
    }
}

//������
class Consumer implements Runnable {
    private Container con;

    public Consumer(Container con) {
        this.con = con;
    }

    @Override    //����
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println("�� <������ " + con.pop().id);
        }
    }
}

//������(��Ʒ�ֿ�)
class Container {
    private Product[] products = new Product[10];
    private int count = 0;

    //�洢��Ʒ
    public synchronized void push(Product products) {
        //�޿ռ䣬�����������룬�ȴ��ռ��ͷ�
        if (count == this.products.length) {
            try {
                this.wait();
            } catch (InterruptedException ignored) {
            }
        }
        this.products[count] = products;
        count++;
        //���ѵȴ����߳�
        notifyAll();
    }

    //��ȡ��Ʒ
    public synchronized Product pop() {
        //�޲�Ʒ���������ѣ��ȴ�����
        if (count == 0) {
            try {
                this.wait();
            } catch (InterruptedException ignored) {
            }
        }
        count--;
        Product products = this.products[count];
        notifyAll();
        return products;
    }
}

//�������Ĳ�Ʒ
class Product {
    int id;

    public Product(int id) {
        this.id = id;
    }
}