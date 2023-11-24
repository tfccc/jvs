package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-05 15:03
 * @note: 静态代理
 **/
public class S_StaticProxy {
    public static void main(String[] args) {
        SingingStar star=new SingingStar();
        Agent agent=new Agent(star);

        agent.process();
    }
}

interface Star{
    void interview();   //面谈
    void sign();        //签合同
    void show();        //演出
    void payment();     //付款
    void process();     //全部流程
}

class SingingStar implements Star{

    @Override
    public void interview() {
        System.out.println("歌手：面谈");
    }
    @Override
    public void sign() {
        System.out.println("歌手：签合同");
    }
    @Override
    public void show() {
        System.out.println("歌手：演出");
    }
    @Override
    public void payment() {
        System.out.println("歌手：结款");
    }
    @Override
    public void process(){
        this.interview();
        this.sign();
        this.show();
        this.payment();
    }
}

class Agent implements Star{
    private SingingStar star;

    public Agent(SingingStar star) {
        this.star = star;
    }
    @Override
    public void interview() {
        System.out.println("经纪人：面谈");
    }
    @Override
    public void sign() {
        System.out.println("经纪人：签合同");
    }
    @Override
    public void show() {
        this.star.show();
    }
    @Override
    public void payment() {
        System.out.println("经纪人：结款");
    }
    @Override
    public void process(){
        this.interview();
        this.sign();
        this.show();
        this.payment();
    }
}