package pac09_GOF;

/**
 * @author TFC
 * @date 2019��8��14�� ����9:53:27
 * @note ����ģʽ(������ʵ��������, ʵ�ִ����ߵ����ߵķ���)
 *
 * һ.ģʽ����:
 *     1.�򵥹���ģʽ(����)
 *         (a)�ŵ㣺ʵ�ʽṹ��,ʹ�ü�,�õ����
 * 	       (b)ȱ�㣺��һ���̶��ϲ��������ԭ��,��չ�Բ�(������Ҫ�޸��ڲ�����)
 *     2.��������ģʽ
 *         (a)�ŵ㣺��չ�µ��಻��Ҫ�޸�Դ��
 *         (b)ȱ�㣺��Ҫ���Ӹ�������ļ��Դﵽ�޸�Ŀ��
 *     3.���󹤳�ģʽ
 *         (a)�ŵ㣺�����ӹ�����,��������ڲ��Բ�Ʒ�����Լ��
 *         (b)ȱ�㣺�������Ӳ�Ʒ��,�����Ϊ����
 *
 * ��.��ɫ����:
 * 	   1.�򵥹��������幤���������Ʒ�������Ʒ
 * 	   2.�������������󹤳������幤���������Ʒ�������Ʒ
 * 	   3.���󹤳������󹤳������幤���������Ʒ�������Ʒ��(�����Ʒ��)
 */
public class T02_Factory {
    public static void main(String[] args) {
        //1�򵥹���ģʽ
        System.out.println("1.�򵥹���");
        Car car2 = SimpleFac.createCar("Byd");
        car2.run();
        System.out.println("---------------");
        //2.��������ģʽ
        System.out.println("2.��������");
        Car c3 = new AudiFac().createCar();
        c3.run();
        System.out.println("---------------");
        //3.���󹤳�ģʽ
        System.out.println("3.���󹤳�");
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
 *                          1.�򵥹���
 * 1.���幤��(���һ���Ʒ)
 * 2.�����Ʒ
 * 3.�����Ʒ
 *****************************************************************/
class SimpleFac {
    //a.��������(���ַ���)
    public static Car createCar(String name) {
        if (name.equals("Audi"))
            return new Audi();
        else if (name.equals("Byd"))
            return new Byd();
        else
            return null;
    }

    //b.��������(�ַ���)
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
 *                           2.��������
 * 1.���󹤳�(������һ���Ʒ)
 * 2.���幤��
 * 3.�����Ʒ
 * 4.�����Ʒ
 *****************************************************************/
//���幤��
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

//���󹤳�
interface CarFac {
    Car createCar();
}


/*****************************************************************
 *                           3.���󹤳�
 * 1.���󹤳�(�����Ʒ, ���ֻ��һ����Ʒ, ���˻�Ϊ��������)
 * 2.���幤��
 * 3.�����Ʒ
 * 4.�����Ʒ
 *****************************************************************/

//1.���󹤳�
interface AbstractFac {
    Motorcycle createMotorcycle();

    Bicycle creatBicycle();
}

//2.���幤��
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

//3.�����Ʒ
interface Motorcycle {
    void run();
}

interface Bicycle {
    void run();
}

//4.�����Ʒ
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


