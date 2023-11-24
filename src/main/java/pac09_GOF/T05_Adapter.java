package pac09_GOF;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-05 13:15
 * @note: ������ģʽ
 *
 * *1.��һ����Ľӿ�ת������������һ���ӿڣ���ԭ�������ݵĶ����һ����(������ʵ�ʵ�ת��ͷ)��
 * *2.������ϵͳ�ĵ������졢����
 * *3.���úϳɾۺ�ԭ��
 *
 * ��ɫ���ࣺ
 * 1.Adapter(������)
 * 2.Adaptee(���������)
 * 3.Target(Ŀ��ӿ�)
 *
 **/
public class T05_Adapter {

    public static void main(String[] args) {
        MyMicroUsb myMicroUsb = new MyMicroUsb();
        ChargingSocket.doCharging(myMicroUsb);

        System.out.println("\n----------------����microUsb----------------\n");
        Typec typec = new MicroToTypecAdapter(myMicroUsb);
        ChargingSocket.doCharging(typec);
    }
}

//target: ������Ŀ�����
interface Typec extends ChargingInterface {
}

//adaptee: ���������
class MyMicroUsb implements ChargingInterface {
    public void charge() {
        System.out.println("MyMicroUsb.charge()");
    }
}

//adapter: ������
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
            System.out.println("�ɳ��---->TypeC");
        } else {
            System.out.println("���ɳ��-->��֧�ָýӿ�");
        }
    }
}