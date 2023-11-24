package pac09_GOF;

/**
 * @author TFC
 * @date 2019年8月14日 上午9:53:27
 * @note 工厂模式(主用于实例化对象, 实现创建者调用者的分离)
 *
 * 一.模式分类:
 *     1.简单工厂模式(常用)
 *         (a)优点：实际结构简单,使用简单,用的最多
 * 	       (b)缺点：在一定程度上不符合设计原则,扩展性差(增添需要修改内部代码)
 *     2.工厂方法模式
 *         (a)优点：扩展新的类不需要修改源码
 *         (b)缺点：需要增加更多的类文件以达到修改目的
 *     3.抽象工厂模式
 *         (a)优点：可增加工厂类,可在类的内部对产品族进行约束
 *         (b)缺点：不可增加产品类,代码较为复杂
 *
 * 二.角色分类:
 * 	   1.简单工厂：具体工厂、抽象产品、具体产品
 * 	   2.工厂方法：抽象工厂、具体工厂、抽象产品、具体产品
 * 	   3.抽象工厂：抽象工厂、具体工厂、抽象产品、具体产品、(抽象产品族)
 */
public class T02_Factory {
    public static void main(String[] args) {
        //1简单工厂模式
        System.out.println("1.简单工厂");
        Car car2 = SimpleFac.createCar("Byd");
        car2.run();
        System.out.println("---------------");
        //2.方法工厂模式
        System.out.println("2.方法工厂");
        Car c3 = new AudiFac().createCar();
        c3.run();
        System.out.println("---------------");
        //3.抽象工厂模式
        System.out.println("3.抽象工厂");
        AbstractFac fac1 = new Fac01();
        AbstractFac fac2 = new Fac02();
        Motorcycle motorcycle1 = fac1.createMotorcycle();
        Motorcycle motorcycle2 = fac2.createMotorcycle();
        Bicycle bicycle1 = fac1.creatBicycle();
        Bicycle bicycle2 = fac2.creatBicycle();
        motorcycle1.run();
        motorcycle2.run();
        bicycle1.run();
        bicycle2.run();
    }
}


/*****************************************************************
 *                          1.简单工厂
 * 1.具体工厂(针对一类产品)
 * 2.抽象产品
 * 3.具体产品
 *****************************************************************/
class SimpleFac {
    //a.创建方法(不分方法)
    public static Car createCar(String name) {
        if (name.equals("Audi"))
            return new Audi();
        else if (name.equals("Byd"))
            return new Byd();
        else
            return null;
    }

    //b.创建方法(分方法)
    public static Car createAudi() {
        return new Audi();
    }
}

interface Car {
    void run();
}

class Audi implements Car {
    @Override
    public void run() {
        System.out.println("Audi is running");
    }
}

class Byd implements Car {
    @Override
    public void run() {
        System.out.println("Byd  is running");
    }
}


/*****************************************************************
 *                           2.工厂方法
 * 1.抽象工厂(仅抽象一类产品)
 * 2.具体工厂
 * 3.抽象产品
 * 4.具体产品
 *****************************************************************/
//具体工厂
class AudiFac implements CarFac {
    @Override
    public Car createCar() {
        return new Audi();
    }
}
class BydFac implements CarFac {
    @Override
    public Car createCar() {
        return new Byd();
    }
}

//抽象工厂
interface CarFac {
    Car createCar();
}


/*****************************************************************
 *                           3.抽象工厂
 * 1.抽象工厂(多类产品, 如果只有一个产品, 则退化为工厂方法)
 * 2.具体工厂
 * 3.抽象产品
 * 4.具体产品
 *****************************************************************/

//1.抽象工厂
interface AbstractFac {
    Motorcycle createMotorcycle();

    Bicycle creatBicycle();
}

//2.具体工厂
class Fac01 implements AbstractFac {
    @Override
    public Motorcycle createMotorcycle() {
        return new Motorcycle1();
    }

    @Override
    public Bicycle creatBicycle() {
        return new Bicycle1();
    }
}

class Fac02 implements AbstractFac {
    @Override
    public Motorcycle createMotorcycle() {
        return new Motorcycle2();
    }

    @Override
    public Bicycle creatBicycle() {
        return new Bicycle2();
    }
}

//3.抽象产品
interface Motorcycle {
    void run();
}

interface Bicycle {
    void run();
}

//4.具体产品
class Motorcycle1 implements Motorcycle {
    @Override
    public void run() {
        System.out.println("motor1 is running...");
    }
}

class Bicycle1 implements Bicycle {
    @Override
    public void run() {
        System.out.println("bicycle1 is running...");
    }
}

class Motorcycle2 implements Motorcycle {
    @Override
    public void run() {
        System.out.println("motor2 is running...");
    }
}

class Bicycle2 implements Bicycle {
    @Override
    public void run() {
        System.out.println("bicycle2 is running...");
    }
}


