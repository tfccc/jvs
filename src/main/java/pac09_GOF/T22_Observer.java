package pac09_GOF;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2019-12-28 14:45
 * @note: �۲���ģʽ(�Է�����Ϣ�ı�۲��ߵ�״̬Ϊ��)
 *
 * 1.ģʽ��Ҫ���۲��߹۲졢������������������Ϣ��������Ϣ���ı�
 *             �ı��Լ�����Ϊ��״̬��
 * 2.����
 * ��1���㲥��̨��Ŀ��Ⱥ��㲥��Ϣ
 * ��2���������У�һ����˵�����������յ���Ϣ
 *  (3) �ֻ���Ϣ�����ͣ��ֻ��˵Ľ���
 *
 * 3.��ɫ����
 * ��1�����󱻹۲����/��Ϣ������
 * ��2�����屻�۲����/��Ϣ������
 * ��3������۲���
 * ��4������۲���
 *
 * 4.ʵ��Ӧ��
 * ��1�������ҳ���
 * ��2��������Ϸ�����˶�ս��
 * ��3���ƶ��ˡ�����˵���Ϣ�㲥����
 * ��4���ʼ�����
 **/
public class T22_Observer {
    public static void main(String[] args) {
        ConcreteSubject sub = new ConcreteSubject();
        ConcreteOb ob1 = new ConcreteOb();
        ConcreteOb ob2 = new ConcreteOb();
        ConcreteOb ob3 = new ConcreteOb();
        sub.addObserver(ob1);
        sub.addObserver(ob2);
        sub.addObserver(ob3);

        //����״̬��֪ͨ�۲���Ⱥ
        sub.setState(100);
        sub.notifyAllObs();
        for (ConcreteOb ob : sub.obList)
            System.out.println(ob.getState());

        sub.setState(200);
        sub.notifyAllObs();
        for (ConcreteOb ob : sub.obList)
            System.out.println(ob.getState());

    }
}

//1.���󱻹۲����
abstract class Subject {
    //�۲����б�(��Ϣ�㲥����Ⱥ)
    List<ConcreteOb> obList = new ArrayList<>();

    //��ӹ۲���
    public void addObserver(ConcreteOb ob) {
        obList.add(ob);
    }

    //ɾ���۲���
    public void removeObserver(ConcreteOb ob) {
        obList.remove(ob);
    }

    //�㲥��֪ͨ�۲���Ⱥ
    public void notifyAllObs() {
        for (Observer ob : obList) {
            ob.update(this);
        }
    }
}

//2.���屻�۲����
class ConcreteSubject extends Subject {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

//3.����۲���
interface Observer {
    void update(Subject subject);
}

//4.����۲���
class ConcreteOb implements Observer {
    private int state; //��Ŀ������ֵ����һ��

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    //�۲��߸���Ŀ�����ı���Ϊ
    @Override
    public void update(Subject subject) {
        this.state = ((ConcreteSubject) subject).getState();
    }
}