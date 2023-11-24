package pac09_GOF;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-05 13:15
 * @note: 适配器模式
 *
 * *1.将一个类的接口转换成期望的另一个接口，让原本不兼容的对象可一起工作(类似于实际的转接头)。
 * *2.常用于系统的迭代改造、升级
 * *3.运用合成聚合原则
 *
 * 角色分类：
 * 1.Adapter(适配器)
 * 2.Adaptee(待适配的类)
 * 3.Target(目标接口)
 *
 **/
public class T05_Adapter {

    public static void main(String[] args) {
        MyMicroUsb myMicroUsb = new MyMicroUsb();
        ChargingSocket.doCharging(myMicroUsb);

        System.out.println("\n----------------适配microUsb----------------\n");
        Typec typec = new MicroToTypecAdapter(myMicroUsb);
        ChargingSocket.doCharging(typec);
    }
}

//target: 适配后的目标对象
interface Typec extends ChargingInterface {
}

//adaptee: 待适配对象
class MyMicroUsb implements ChargingInterface {
    public void charge() {
        System.out.println("MyMicroUsb.charge()");
    }
}

//adapter: 适配器
class MicroToTypecAdapter implements Typec {
    private MyMicroUsb myMicroUsb;

    public MicroToTypecAdapter(MyMicroUsb myMicroUsb) {
        this.myMicroUsb = myMicroUsb;
    }

    public void charge() {
        if (this.myMicroUsb != null) {
            myMicroUsb.charge();
        }
    }
}

interface ChargingInterface {
    void charge();
}

class ChargingSocket {
    public static void doCharging(ChargingInterface chargingInterface) {
        if (chargingInterface instanceof Typec) {
            System.out.println("可充电---->TypeC");
        } else {
            System.out.println("不可充电-->不支持该接口");
        }
    }
}