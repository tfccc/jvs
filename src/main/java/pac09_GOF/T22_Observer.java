package pac09_GOF;

import java.util.ArrayList;
import java.util.List;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2019-12-28 14:45
 * @note: 观察者模式(以发送消息改变观察者的状态为例)
 *
 * 1.模式概要：观察者观察、监听其他对象发来的信息，根据信息来改变
 *             改变自己的行为、状态。
 * 2.场景
 * （1）广播电台向目标群体广播消息
 * （2）聊天室中，一个人说话，其他人收到消息
 *  (3) 手机消息的推送，手机端的接收
 *
 * 3.角色分类
 * （1）抽象被观察对象/消息发送者
 * （2）具体被观察对象/消息发送者
 * （3）抽象观察者
 * （4）具体观察者
 *
 * 4.实际应用
 * （1）聊天室程序
 * （2）网络游戏（多人对战）
 * （3）移动端、桌面端的信息广播机制
 * （4）邮件订阅
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

        //设置状态并通知观察者群
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

//1.抽象被观察对象
abstract class Subject {
    //观察者列表(消息广播对象群)
    List<ConcreteOb> obList = new ArrayList<>();

    //添加观察者
    public void addObserver(ConcreteOb ob) {
        obList.add(ob);
    }

    //删除观察者
    public void removeObserver(ConcreteOb ob) {
        obList.remove(ob);
    }

    //广播、通知观察者群
    public void notifyAllObs() {
        for (Observer ob : obList) {
            ob.update(this);
        }
    }
}

//2.具体被观察对象
class ConcreteSubject extends Subject {
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}

//3.抽象观察者
interface Observer {
    void update(Subject subject);
}

//4.具体观察者
class ConcreteOb implements Observer {
    private int state; //与目标对像的值保持一致

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    //观察者根据目标对象改变行为
    @Override
    public void update(Subject subject) {
        this.state = ((ConcreteSubject) subject).getState();
    }
}