package pac09_GOF;

/**
 * @program: Java_Study
 * @author: TFC
 * @date: 2019-12-28 14:12
 * @note: ״̬ģʽ������ס�Ƶ�Ϊ����
 *
 * 1.ģʽ��Ҫ����һ����Ĳ�ͬ״̬���������Լ�����״ִ̬��ĳЩ��Ϊ��
 *
 * 2.������
 * ��a���������У����ݵ����С�΢�š������ŵ�
 * ��b�����̵ƣ���ơ��̵ơ��Ƶ�
 * ��c�����������µ����Ѹ���ͻ��С����ջ�
 * <p>
 * 3.��ɫ����
 * ��1��Context������
 * ��2��State����״̬��
 * ��3��ConcreteState����״̬��
 * <p>
 * 4.ʵ��Ӧ�ã�
 * ��1������ϵͳ���˺�״̬�Ĺ���
 * ��2���Ƶ�ϵͳ�ķ���ȶ����״̬
 * ��3���̣߳���ͬ״̬���л�
 **/
public class T21_State {
    public static void main(String[] args) {
        RoomContext context = new RoomContext();
        context.setState(new FreeState());
        context.setState(new BookedState());
        context.setState(new CheckedInState());
    }
}

//1.������
class RoomContext {
    private State state;

    //�л�״̬
    public void setState(State state) {
        System.out.print("״̬�޸ĳɹ�,  ");
        this.state = state;
        System.out.print("��ǰ״̬-->");
        this.state.handle();
    }
}

//2.����״̬��
interface State {
    void handle();
}

//3.����״̬��
//3.1�������״̬
class FreeState implements State {
    @Override
    public void handle() {
        System.out.println("״̬1���������");
    }
}

//3.2����Ԥ��״̬
class BookedState implements State {
    @Override
    public void handle() {
        System.out.println("״̬2��������Ԥ��");
    }
}

//3.1������ס״̬
class CheckedInState implements State {
    @Override
    public void handle() {
        System.out.println("״̬3����������ס");
    }
}
