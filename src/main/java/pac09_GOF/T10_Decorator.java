package pac09_GOF;

import java.io.BufferedOutputStream;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-08 20:57
 * @note: װ��ģʽ(��װģʽ)
 *
 * ˵��:
 *   1.��̬Ϊһ�����������¹���,���ʹ�����϶ȡ�
 *   2.װ��ģʽ���úͼ̳����ƣ���װ��ģʽ����ͨ�����Ӽ̳�������չ���ܣ�
 *    �������ɱ�������ϵ������(������������)
 *   3.���Զ�һ��������ж�Ρ���ͬ��װ�Σ�������ͬ����϶���
 *
 * ��ɫ���ࣺ
 *   1.Component          ���󹹼�
 *   2.ConcreteComponent  ���塢��ʵ����
 *   3.Decorator          װ����
 *   4.ConcreteDecorator  ����װ����
 *
 * Ӧ�ã�
 *   1.IO����BufferStream��
 *   2.Swingͼ�ι���
 *   3.Servlet API��ĳЩ��
 *   4.Struts2�ж�ĳЩ����Ĵ���
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

        System.out.println("***һ��װ�ε�λ***");
        AutoCar aCar = new AutoCar(new FlyCar(car));
        aCar.move();
    }
}

//1.���󹹼�
interface NorCar {
    void move();
}

//2.���幹��
class Cars implements NorCar {
    @Override
    public void move() {
        System.out.println("1.��½������");
    }
}

//3.װ����
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

//4.����װ����
class FlyCar extends SuperCar {
    FlyCar(NorCar car) {
        super(car);
    }

    private void fly() {
        System.out.println("2.�����Ϸ�");
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
        System.out.println("3.�Զ���ʻ");
    }

    @Override
    public void move() {
        super.move();
        auto();
    }
}