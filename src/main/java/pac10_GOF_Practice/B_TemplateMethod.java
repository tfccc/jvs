package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-05 12:53
 * @note: 模板方法模式
 **/
public class B_TemplateMethod {
    public static void main(String[] args) {
        Deposit deposit = new Deposit();
        deposit.process();

        System.out.println("-----");
        ActivateCard actCard = new ActivateCard();
        actCard.process();

        System.out.println("-----");
        AbsTemplate withdraw = new AbsTemplate() {
            @Override
            public void Service() {
                System.out.println("2.取款");
            }
        };
        withdraw.process();

    }
}


abstract class AbsTemplate{
    public void lineUp(){
        System.out.println("1.排队(模板方法)");
    }
    //钩子
    public abstract void Service();
    public void comment(){
        System.out.println("3.评价(模板方法)");
    }
    public void process(){
        this.lineUp();
        this.Service();
        this.comment();
    }
}

class Deposit extends AbsTemplate{
    @Override
    public void Service() {
        System.out.println("2.存款");
    }
}

class ActivateCard extends AbsTemplate{
    @Override
    public void Service() {
        System.out.println("2.开卡");
    }
}