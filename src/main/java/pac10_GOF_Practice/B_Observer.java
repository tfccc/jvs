package pac10_GOF_Practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-07 10:32
 * @note: �۲���
 *
 *  3.��ɫ����
 *  ��1�����󱻹۲����/��Ϣ������
 *  ��2�����屻�۲����/��Ϣ������
 *  ��3������۲���
 *  ��4������۲���
 *
 **/
public class B_Observer {
    public static void main(String[] args) {
        ConcretePerformer performer=new ConcretePerformer();
        System.out.println("ԭʼֵ��"+performer.getState()+"\n--------");
        Observer o1=new Observer_A();
        Observer o2=new Observer_B();
        Observer o3=new Observer_C();

        performer.addObserver(o1);
        performer.addObserver(o2);
        performer.addObserver(o3);

        performer.setState(50);
        performer.notifyAllObservers();
        performer.setState(100);
        performer.notifyAllObservers();

    }
}
abstract class Performer {
    int state;
    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer) {
        this.observerList.add(observer);
    }
    public void removeObserver(Observer observer) {
        this.observerList.remove(observer);
    }
    public void notifyAllObservers() {
        for (Observer ob : observerList) {
            ob.update(this);
        }
        System.out.println("--------");
    }

}
class ConcretePerformer extends Performer {

    public int getState() {
        return state;
    }
    public void setState(int state) {
        this.state = state;
    }
    @Override
    public void notifyAllObservers(){
        System.out.println("�޸�ֵ��"+state);
        System.out.println("֪ͨ���й۲���:");
        super.notifyAllObservers();
    }
}


abstract class Observer {
    int state;
    abstract void update(Performer performer);
}
class Observer_A extends Observer {
    @Override
    void update(Performer performer) {
        this.state = performer.state;
        System.out.println("A�ı��"+this.state);
    }
}
class Observer_B extends Observer {
    @Override
    void update(Performer performer) {
        this.state = performer.state;
        System.out.println("B�ı��"+this.state);
    }
}
class Observer_C extends Observer {
    @Override
    void update(Performer performer) {
        this.state = performer.state;
        System.out.println("C�ı��"+this.state);
    }
}