package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-07 10:06
 * @note: 策略模式
 * <p>
 * 角色分类：
 * 1.策略算法接口
 * 2.具体算法
 * 3.上下文类
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

//1.策略1——老客户——少量
class Strategy1_Old_Few extends DiscountStrategy {
    Strategy1_Old_Few() {
        this.strategyName = "老客户——>少量";
        this.discount = 0.85;
    }

    @Override
    public double quotedPrice(double price) {
        return price * discount;
    }
}
//2.策略2——老客户——大量
class Strategy2_Old_Many extends DiscountStrategy {
    Strategy2_Old_Many() {
        this.strategyName = "老客户——>大量";
        this.discount = 0.8;
    }

    @Override
    public double quotedPrice(double price) {
        return price * discount;
    }
}
//3.策略3——新客户——少量
class Strategy3_New_Few extends DiscountStrategy {
    Strategy3_New_Few() {
        this.strategyName = "新客户——>少量";
        this.discount = 0.95;
    }

    @Override
    public double quotedPrice(double price) {
        return price * discount;
    }
}
//4.策略4——新客户——大量
class Strategy4_New_Many extends DiscountStrategy {
    Strategy4_New_Many() {
        this.strategyName = "新客户——>大量";
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
        System.out.println("策略名：" + this.strategy.strategyName);
        System.out.println("折  扣：" + this.strategy.discount);
        System.out.println("原  价：" + quotedPrice);
        System.out.println("成交价：" + strategy.quotedPrice(quotedPrice));
    }
}