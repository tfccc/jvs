package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-05 15:27
 * @note: 装饰器模式
 **/
public class S_Decorator {
    public static void main(String[] args) {
        MyCar car=new MyCar();
        car.run();
        FlyCar flyCar=new FlyCar(car);
        flyCar.run();
    }
}

interface Car_Int{
    void run();
}

class MyCar implements Car_Int{
    @Override
    public void run() {
        System.out.println("在陆地上跑");
    }
}

class FlyCar extends MyCar{
    private MyCar car;

    public FlyCar(MyCar car) {
        this.car = car;
    }
    public void runInAir(){
        System.out.println("在空中飞");
    }
    public void run(){
        super.run();
        runInAir();
    }
}