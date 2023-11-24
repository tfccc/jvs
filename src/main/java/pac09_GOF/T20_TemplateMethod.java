package pac09_GOF;

/**
 * @project: Java_2019.06.10
 * @author: TFC
 * @date: 2019-10-06 10:50
 * @note: 模板方法模式：以银行业务办理为例
 *
 * *1.模式概要：定义一个操作中的算法框架，将某些步骤延迟到子类实现，
 *    这样在子类不改变算法结构的前提下重新定义该算法的某些特定步骤。
 * *2.使用场景：整体步骤固定，小部分易变，需要自定义实现的情况
 *
 * 角色分类：
 *      1.抽象模板方法类
 *      2.实现子类(或直接使用匿名实现)
 *
 * 实际应用：
 *      1.数据库访问封装
 *      2.Junit单元测试
 *      3.Servlet的doPost/doGet
 *      4.Spring中JDBCTemplate、HibernateTemplate
 **/
public class T20_TemplateMethod {
    public static void main(String[] args) {
        //1.自定义类实现
        BankTemplateMethod dm = new DrawMoney();
        dm.process();
        System.out.println("--------------");

        //2.匿名实现
        BankTemplateMethod b1 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("业务2：存款");
            }
        };
        b1.process();
    }
}

//1.抽象模板方法类
abstract class BankTemplateMethod {
    public void takeNumber() {
        System.out.println("1.取号排队");
    }

    public abstract void transact();

    public void evaluate() {
        System.out.println("3.服务评价");
    }

    //模板方法合集
    public final void process() {
        this.takeNumber();
        this.transact();    //钩子方法，跟子类中的具体方法挂钩
        this.evaluate();
    }
}

//2.实现子类
class DrawMoney extends BankTemplateMethod {
    @Override
    public void transact() {
        System.out.println("业务1：取款");
    }
}

class DepositMoney extends BankTemplateMethod {
    @Override
    public void transact() {
        System.out.println("业务2：存款");
    }
}