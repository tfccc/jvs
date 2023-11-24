package pac09_GOF;

import java.io.BufferedOutputStream;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-08 20:57
 * @note: 装饰模式(包装模式)
 *
 * 说明:
 *   1.动态为一个对象增加新功能,降低代码耦合度。
 *   2.装饰模式作用和继承类似，但装饰模式无需通过增加继承子类扩展功能，
 *    更加灵活，可避免类体系的膨胀(创建过多子类)
 *   3.可以对一个对象进行多次、不同的装饰，创建不同的组合对象。
 *
 * 角色分类：
 *   1.Component          抽象构件
 *   2.ConcreteComponent  具体、真实构件
 *   3.Decorator          装饰器
 *   4.ConcreteDecorator  具体装饰器
 *
 * 应用：
 *   1.IO流的BufferStream等
 *   2.Swing图形构件
 *   3.Servlet API中某些类
 *   4.Struts2中对某些对象的处理
 **/
public class T10_Decorator {

    public static void main(String[] args) {
        Cars car = new Cars();
        car.move();

        System.out.println("*****************");
        FlyCar flyCar = new FlyCar(car);
        flyCar.move();


        System.out.println("*****************");
        AutoCar autoCar = new AutoCar(flyCar);
        autoCar.move();

        System.out.println("***一步装饰到位***");
        AutoCar aCar = new AutoCar(new FlyCar(car));
        aCar.move();
    }
}

//1.抽象构件
interface NorCar {
    void move();
}

//2.具体构件
class Cars implements NorCar {
    @Override
    public void move() {
        System.out.println("1.在陆地上跑");
    }
}

//3.装饰器
 abstract class SuperCar implements NorCar {
    private NorCar car;

    SuperCar(NorCar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

//4.具体装饰器
class FlyCar extends SuperCar {
    FlyCar(NorCar car) {
        super(car);
    }

    private void fly() {
        System.out.println("2.在天上飞");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

class AutoCar extends SuperCar {
    AutoCar(NorCar car) {
        super(car);
    }

    private void auto() {
        System.out.println("3.自动驾驶");
    }

    @Override
    public void move() {
        super.move();
        auto();
    }
}