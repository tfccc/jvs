package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-05 15:03
 * @note: ��̬����
 **/
public class S_StaticProxy {
    public static void main(String[] args) {
        SingingStar star=new SingingStar();
        Agent agent=new Agent(star);

        agent.process();
    }
}

interface Star{
    void interview();   //��̸
    void sign();        //ǩ��ͬ
    void show();        //�ݳ�
    void payment();     //����
    void process();     //ȫ������
}

class SingingStar implements Star{

    @Override
    public void interview() {
        System.out.println("���֣���̸");
    }
    @Override
    public void sign() {
        System.out.println("���֣�ǩ��ͬ");
    }
    @Override
    public void show() {
        System.out.println("���֣��ݳ�");
    }
    @Override
    public void payment() {
        System.out.println("���֣����");
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
        System.out.println("�����ˣ���̸");
    }
    @Override
    public void sign() {
        System.out.println("�����ˣ�ǩ��ͬ");
    }
    @Override
    public void show() {
        this.star.show();
    }
    @Override
    public void payment() {
        System.out.println("�����ˣ����");
    }
    @Override
    public void process(){
        this.interview();
        this.sign();
        this.show();
        this.payment();
    }
}