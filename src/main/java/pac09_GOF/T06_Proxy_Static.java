package pac09_GOF;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-06 09:42
 * @note: ��̬����: ����������ȱ�д��
 *
 * *1.�������ã�ͨ�Դ������ƶ���ķ��ʡ�����ϸ���Ʒ���ĳ������ķ�����
 *    �ڵ���ǰ��ֱ���ǰ�����ô���
 * *2.����ģʽ(��̬����)ΪAOP��̵ĺ��Ļ��ơ�
 *
 * ��ɫ���ࣺ
 *   1.�����ɫ����������ɫ����ʵ��ɫ�Ĺ������ⷽ����
 *   2.��ʵ��ɫ��������ʵ��ɫ��ʵ�ֵ�ҵ���߼����������ɫ���á�
 *   3.�����ɫ��������ʵ��ɫ��ʵ�������ҵ���߼���
 *
 **/
public class T06_Proxy_Static {
    public static void main(String[] args) {
        AbstractRole star = new Star();
        AbstractRole agent = new Agent(star);
        agent.confer();
        agent.singContract();
        agent.confer();
    }
}

//1.�����ɫ
interface AbstractRole {
    //1,2,4�ɴ����ɫ���, 3����ʵ��ɫ��ɡ�
    void confer();          //1.��̸
    void singContract();    //2.ǩ��ͬ
    void show();            //3.�ݳ�
    void checkOut();        //4.���
}

//2.��ʵ��ɫ(����)
class Star implements AbstractRole {
    @Override
    public void confer() {
        System.out.println("����--->��̸");
    }

    @Override
    public void singContract() {
        System.out.println("����--->ǩ��ͬ");
    }

    @Override
    public void show() {
        System.out.println("����--->�ݳ�");
    }

    @Override
    public void checkOut() {
        System.out.println("����--->�տ�");
    }
}

//3.�����ɫ(������)
class Agent implements AbstractRole {
    private AbstractRole star;

    Agent(AbstractRole star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("������-->��̸");
    }

    @Override
    public void singContract() {
        System.out.println("������-->ǩ��ͬ");
    }

    //������ʵ��ɫʵ��show����
    @Override
    public void show() {
        star.show();
    }

    @Override
    public void checkOut() {
        System.out.println("������-->�տ�");
    }
}

