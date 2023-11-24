package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-06 20:09
 * @note: ״̬ģʽ
 *
 *  3.��ɫ����
 *  ��1��Context������
 *  ��2��State����״̬��
 *  ��3��ConcreteState����״̬��
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
        System.out.println("1.�������");
    }
}

class Booked implements State{
    @Override
    public void printState() {
        System.out.println("2.������Ԥ��");
    }
}

class CheckedIn implements State{
    @Override
    public void printState() {
        System.out.println("3.��������ס");
    }
}

class RoomContext{
    State state;

    public RoomContext() {
        this.state=new Free();
    }

    public void setState(State state){
        System.out.println("�޸�ǰ״̬��");
        this.state.printState();
        System.out.println("�޸ĺ�״̬��");
        this.state=state;
        state.printState();
        System.out.println("-------------");
    }
}