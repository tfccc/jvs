package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-05 12:53
 * @note: ģ�巽��ģʽ
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
                System.out.println("2.ȡ��");
            }
        };
        withdraw.process();

    }
}


abstract class AbsTemplate{
    public void lineUp(){
        System.out.println("1.�Ŷ�(ģ�巽��)");
    }
    //����
    public abstract void Service();
    public void comment(){
        System.out.println("3.����(ģ�巽��)");
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
        System.out.println("2.���");
    }
}

class ActivateCard extends AbsTemplate{
    @Override
    public void Service() {
        System.out.println("2.����");
    }
}