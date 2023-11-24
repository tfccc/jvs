package pac09_GOF;

/**
 * @project: Java_2019.06.10
 * @author: TFC
 * @date: 2019-10-06 10:19
 * @note: ����ģʽ
 *
 * *1.������������ͬ�����󣬲�ͬ��������/�������ͣ���Ҫ���ò�ͬ�Ĵ���ʽ
 * (���Բ���if��else������ƣ���Υ������ԭ�򣬲�����ά��)
 * *2.���˼·���ṩһ���������ġ��㷨�塱�������û����㷨������ѡһ����
 * �����ĳһ���⣬ͬʱ���Ը������¼��㷨��
 *
 * ��ɫ���ࣺ
 * 1.�����㷨�ӿ�
 * 2.�����㷨
 * 3.��������
 *
 * ʵ��Ӧ�ã�
 * 1.GUI��̵Ĳ��ֹ�����
 * 2.Spring����е�Resource�ӿ�
 * 3.Servlet�е��ò�ͬ����Servlet����
 **/
public class T19_Strategy {
    public static void main(String[] args) {
        Strategy s1 = new NewCustomerFewStra();
        Strategy s2 = new NewCustomerManyStra();
        Strategy s3 = new OldCustomerFewStra();
        Strategy s4 = new OldCustomerManyStra();
        Context c1 = new Context(s2);
        c1.bringPrice(1000);
    }
}

//1.�����㷨�ӿ�
interface Strategy {
    double getPrice(double price);
}

//2.�������
class NewCustomerFewStra implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("1.1�¿ͻ�-->С����-->ԭ��");
        return price;
    }
}

class NewCustomerManyStra implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("1.2�¿ͻ�-->������-->0.9��");
        return price * 0.9;
    }
}

class OldCustomerFewStra implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("1.2�Ͽͻ�-->С����-->0.8��");
        return price * 0.8;
    }
}

class OldCustomerManyStra implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("1.2�Ͽͻ�-->������-->0.7��");
        return price * 0.7;
    }
}

//3.��������
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void bringPrice(double price) {
        System.out.println("��ǰ����:" + strategy.getPrice(price));
    }
}