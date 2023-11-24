package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-06 20:09
 * @note: 状态模式
 *
 *  3.角色分类
 *  （1）Context环境类
 *  （2）State抽象状态类
 *  （3）ConcreteState具体状态类
 *
 **/
public class B_State {
    public static void main(String[] args) {
        RoomContext state=new RoomContext();
        state.setState(new Booked());
        state.setState(new CheckedIn());
    }
}

interface State{
    void printState();
}

class Free implements State{
    @Override
    public void printState() {
        System.out.println("1.房间空闲");
    }
}

class Booked implements State{
    @Override
    public void printState() {
        System.out.println("2.房间已预订");
    }
}

class CheckedIn implements State{
    @Override
    public void printState() {
        System.out.println("3.房间已入住");
    }
}

class RoomContext{
    State state;

    public RoomContext() {
        this.state=new Free();
    }

    public void setState(State state){
        System.out.println("修改前状态：");
        this.state.printState();
        System.out.println("修改后状态：");
        this.state=state;
        state.printState();
        System.out.println("-------------");
    }
}