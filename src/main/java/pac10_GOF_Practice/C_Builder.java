package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-04 15:06
 * @note: ������ģʽ
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
        return new CarSet(1000,"��Ƥ����");
    }
    @Override
    public CarTyre buildTyre() {
        return new CarTyre(2500,"������̥");
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
        System.out.println("����װ�����......");
        return car;
    }
}

//Car
class Car{
    CarSet set;
    CarTyre tyre;

    public void qualityCheck() {
        if (set != null && tyre != null) {
            System.out.println("��������ɹ�...");
        } else {
            System.out.println("��������ʧ��...");
        }
    }
}

//����
class CarSet{
    public int price;
    public String name;

    public CarSet(int price, String name) {
        this.price = price;
        this.name = name;
    }
}
//��̥
class CarTyre {
    public int price;
    public String name;

    public CarTyre(int price, String name) {
        this.price = price;
        this.name = name;
    }
}