package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-07 10:06
 * @note: ����ģʽ
 * <p>
 * ��ɫ���ࣺ
 * 1.�����㷨�ӿ�
 * 2.�����㷨
 * 3.��������
 **/
public class B_Strategy {
    public static void main(String[] args) {
        DiscountStrategy s1 = new Strategy1_Old_Few ();
        DiscountStrategy s2 = new Strategy2_Old_Many();
        DiscountStrategy s3 = new Strategy3_New_Few ();
        DiscountStrategy s4 = new Strategy4_New_Many();

        Context context = new Context(s2);
        context.executeStrategy(1000);
    }
}


abstract class DiscountStrategy {
    String strategyName;
    double discount;
    abstract double quotedPrice(double price);
}

//1.����1�����Ͽͻ���������
class Strategy1_Old_Few extends DiscountStrategy {
    Strategy1_Old_Few() {
        this.strategyName = "�Ͽͻ�����>����";
        this.discount = 0.85;
    }

    @Override
    public double quotedPrice(double price) {
        return price * discount;
    }
}
//2.����2�����Ͽͻ���������
class Strategy2_Old_Many extends DiscountStrategy {
    Strategy2_Old_Many() {
        this.strategyName = "�Ͽͻ�����>����";
        this.discount = 0.8;
    }

    @Override
    public double quotedPrice(double price) {
        return price * discount;
    }
}
//3.����3�����¿ͻ���������
class Strategy3_New_Few extends DiscountStrategy {
    Strategy3_New_Few() {
        this.strategyName = "�¿ͻ�����>����";
        this.discount = 0.95;
    }

    @Override
    public double quotedPrice(double price) {
        return price * discount;
    }
}
//4.����4�����¿ͻ���������
class Strategy4_New_Many extends DiscountStrategy {
    Strategy4_New_Many() {
        this.strategyName = "�¿ͻ�����>����";
        this.discount = 0.9;
    }

    @Override
    public double quotedPrice(double price) {
        return price * discount;
    }
}

class Context {
    private DiscountStrategy strategy;

    Context(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public void executeStrategy(double quotedPrice) {
        System.out.println("��������" + this.strategy.strategyName);
        System.out.println("��  �ۣ�" + this.strategy.discount);
        System.out.println("ԭ  �ۣ�" + quotedPrice);
        System.out.println("�ɽ��ۣ�" + strategy.quotedPrice(quotedPrice));
    }
}