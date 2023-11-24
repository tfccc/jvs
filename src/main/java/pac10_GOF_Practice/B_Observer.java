package pac10_GOF_Practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-07 10:32
 * @note: 观察者
 *
 *  3.角色分类
 *  （1）抽象被观察对象/消息发送者
 *  （2）具体被观察对象/消息发送者
 *  （3）抽象观察者
 *  （4）具体观察者
 *
 **/
public class B_Observer {
    public static void main(String[] args) {
        ConcretePerformer performer=new ConcretePerformer();
        System.out.println("原始值："+performer.getState()+"\n--------");
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
        System.out.println("修改值："+state);
        System.out.println("通知所有观察者:");
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
        System.out.println("A改变后："+this.state);
    }
}
class Observer_B extends Observer {
    @Override
    void update(Performer performer) {
        this.state = performer.state;
        System.out.println("B改变后："+this.state);
    }
}
class Observer_C extends Observer {
    @Override
    void update(Performer performer) {
        this.state = performer.state;
        System.out.println("C改变后："+this.state);
    }
}