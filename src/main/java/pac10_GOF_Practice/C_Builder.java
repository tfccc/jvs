package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-04 15:06
 * @note: 建造者模式
 **/
public class C_Builder {
    public static void main(String[] args) {
        CarBuilder builder=new CarBuilder();
        Director director=new Director(builder);
        Car car=director.directCar();

        car.qualityCheck();

    }
}

interface Builder{
    CarSet buildSet();
    CarTyre buildTyre();
}

class CarBuilder implements Builder{

    @Override
    public CarSet buildSet() {
        return new CarSet(1000,"真皮座椅");
    }
    @Override
    public CarTyre buildTyre() {
        return new CarTyre(2500,"防滑轮胎");
    }
}

class Director {
    CarBuilder builder;

    public Director(CarBuilder builder) {
        this.builder = builder;
    }

    public Car directCar(){
        Car car=new Car();
        car.set=builder.buildSet();
        car.tyre=builder.buildTyre();
        System.out.println("车辆装载完毕......");
        return car;
    }
}

//Car
class Car{
    CarSet set;
    CarTyre tyre;

    public void qualityCheck() {
        if (set != null && tyre != null) {
            System.out.println("汽车建造成功...");
        } else {
            System.out.println("汽车建造失败...");
        }
    }
}

//座椅
class CarSet{
    public int price;
    public String name;

    public CarSet(int price, String name) {
        this.price = price;
        this.name = name;
    }
}
//轮胎
class CarTyre {
    public int price;
    public String name;

    public CarTyre(int price, String name) {
        this.price = price;
        this.name = name;
    }
}