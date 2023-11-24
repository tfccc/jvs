package pac05_Thread;

/**
 * @author TFC
 * @date 2019年7月19日 下午12:58:06
 * @note 线程同步的"生产者消费者模式"
 *
 * 1.管程法   pipeline()   //等待、唤醒
 * 2.信号灯法 signalLamp() //true、false判断
 *
 */
public class T22_BoundedBuffer {
    public static void main(String[] args) {
        //1.管程法
        pipeline();
    }

    private static void pipeline() {
        Container container = new Container();
        Producer pro = new Producer(container);
        Consumer con = new Consumer(container);
        new Thread(pro, "生产者").start();
        new Thread(con, "消费者").start();
    }
}

//生产者
class Producer implements Runnable {
    private Container con;

    public Producer(Container con) {
        this.con = con;
    }

    @Override
	//生产
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println("■ ———> " + i);
            //生产的产品加入缓存区
            con.push(new Product(i));
        }
    }
}

//消费者
class Consumer implements Runnable {
    private Container con;

    public Consumer(Container con) {
        this.con = con;
    }

    @Override    //消费
    public void run() {
        for (int i = 1; i < 10; i++) {
            System.out.println("□ <——— " + con.pop().id);
        }
    }
}

//缓冲区(产品仓库)
class Container {
    private Product[] products = new Product[10];
    private int count = 0;

    //存储产品
    public synchronized void push(Product products) {
        //无空间，不能生产放入，等待空间释放
        if (count == this.products.length) {
            try {
                this.wait();
            } catch (InterruptedException ignored) {
            }
        }
        this.products[count] = products;
        count++;
        //唤醒等待的线程
        notifyAll();
    }

    //获取产品
    public synchronized Product pop() {
        //无产品，不能消费，等待生产
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

//缓冲区的产品
class Product {
    int id;

    public Product(int id) {
        this.id = id;
    }
}