package pac09_GOF;

/**
 * @project: Java_2019.06.10
 * @author: TFC
 * @date: 2019-10-06 10:19
 * @note: 策略模式
 *
 * *1.场景：对于相同的请求，不同的请求量/请求类型，需要采用不同的处理方式
 * (可以采用if、else进行设计，但违反开闭原则，不利于维护)
 * *2.设计思路：提供一个解决问题的“算法族”，允许用户从算法族中任选一个算
 * 法解决某一问题，同时可以更换或新加算法。
 *
 * 角色分类：
 * 1.策略算法接口
 * 2.具体算法
 * 3.上下文类
 *
 * 实际应用：
 * 1.GUI编程的布局管理器
 * 2.Spring框架中的Resource接口
 * 3.Servlet中调用不同的子Servlet对象
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

//1.策略算法接口
interface Strategy {
    double getPrice(double price);
}

//2.具体策略
class NewCustomerFewStra implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("1.1新客户-->小批量-->原价");
        return price;
    }
}

class NewCustomerManyStra implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("1.2新客户-->大批量-->0.9折");
        return price * 0.9;
    }
}

class OldCustomerFewStra implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("1.2老客户-->小批量-->0.8折");
        return price * 0.8;
    }
}

class OldCustomerManyStra implements Strategy {
    @Override
    public double getPrice(double price) {
        System.out.println("1.2老客户-->大批量-->0.7折");
        return price * 0.7;
    }
}

//3.上下文类
class Context {
    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void bringPrice(double price) {
        System.out.println("当前报价:" + strategy.getPrice(price));
    }
}