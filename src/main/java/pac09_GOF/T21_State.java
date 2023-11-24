package pac09_GOF;

/**
 * @program: Java_Study
 * @author: TFC
 * @date: 2019-12-28 14:12
 * @note: 状态模式（以入住酒店为例）
 *
 * 1.模式概要：对一个类的不同状态的描述，以及根据状态执行某些行为。
 *
 * 2.场景：
 * （a）电梯运行：电梯的运行、微信、开关门等
 * （b）红绿灯：红灯、绿灯、黄灯
 * （c）网购：已下单、已付款、送货中、已收货
 * <p>
 * 3.角色分类
 * （1）Context环境类
 * （2）State抽象状态类
 * （3）ConcreteState具体状态类
 * <p>
 * 4.实际应用：
 * （1）银行系统中账号状态的管理
 * （2）酒店系统的房间等对象的状态
 * （3）线程，不同状态的切换
 **/
public class T21_State {
    public static void main(String[] args) {
        RoomContext context = new RoomContext();
        context.setState(new FreeState());
        context.setState(new BookedState());
        context.setState(new CheckedInState());
    }
}

//1.环境类
class RoomContext {
    private State state;

    //切换状态
    public void setState(State state) {
        System.out.print("状态修改成功,  ");
        this.state = state;
        System.out.print("当前状态-->");
        this.state.handle();
    }
}

//2.抽象状态类
interface State {
    void handle();
}

//3.具体状态类
//3.1房间空闲状态
class FreeState implements State {
    @Override
    public void handle() {
        System.out.println("状态1：房间空闲");
    }
}

//3.2房间预订状态
class BookedState implements State {
    @Override
    public void handle() {
        System.out.println("状态2：房间已预订");
    }
}

//3.1房间入住状态
class CheckedInState implements State {
    @Override
    public void handle() {
        System.out.println("状态3：房间已入住");
    }
}
