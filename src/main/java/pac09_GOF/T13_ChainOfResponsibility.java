package pac09_GOF;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-20 12:59
 * @note: ������ģʽ:���������Ϊ��
 *
 * ʵ�ַ�ʽ:
 * 1.��ʽʵ��(������)
 * 2.��������(�Ѷ�����������У���������ʱ����ȡ���������ڶ������ʽ)
 *
 * *1.����:���ܹ�����һ������Ķ�������һ���������������ύ������
 *    ���������ܴ�����򴫵ݸ���һ����
 * *2.��ʵ����:�����������ơ���˾����������롢�������ܡ�
 *
 * ��ɫ���ࣺ
 * 1.��������(Handler)
 * 2.���崦����(ConcreteHandler)
 * 3.����ʵ��  (Request)
 *
 * Ӧ�ó�����
 * 1.Java�쳣����
 * 2.Servlet����������ʽ����
 * 3.Struts2����������
 **/
public class T13_ChainOfResponsibility {
    public static void main(String[] args) {
        Leader director = new Directors("��Ŀ�鳤");
        Leader manager = new Manager("��Ŀ����");
        Leader boss = new Boss("��˾�ϰ�");
        //�������¼���ϵ(�γ�����ϵ)
        director.setNextLeader(manager);
        manager.setNextLeader(boss);

        //��������(ָ������ʼ)
        LeaveRequest request = new LeaveRequest("tfc", 25);
        director.handleReq(request);
    }
}

/**�����������*/
//1.��������
abstract class Leader {
    protected String name;
    protected Leader nextLeader;

    public Leader(String name) {
        this.name = name;
    }

    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    public abstract void handleReq(LeaveRequest request);
}

//2.���崦����
//2.1:��Ŀ�鳤
class Directors extends Leader {
    public Directors(String name) {
        super(name);
    }

    @Override
    public void handleReq(LeaveRequest request) {
        if (request.getDays() <= 7) {
            System.out.println("������:" + this.name + "(0~7)");
            request.getInfo();
        } else {
            if (this.nextLeader != null)
                this.nextLeader.handleReq(request);
        }
    }
}

//2.2:��Ŀ����
class Manager extends Leader {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleReq(LeaveRequest request) {
        if (request.getDays() <= 15) {
            System.out.println("������:" + this.name + "(8~15)");
            request.getInfo();
        } else {
            if (this.nextLeader != null)
                this.nextLeader.handleReq(request);
        }
    }
}

//2.3:�ϰ�
class Boss extends Leader {
    public Boss(String name) {
        super(name);
    }

    @Override
    public void handleReq(LeaveRequest request) {
        if (request.getDays() <= 30) {
            System.out.println("������:" + this.name + "(16~30)");
            request.getInfo();
        } else
            System.out.println("��ٹ���, ֱ�Ӵ���");
    }
}

//3.����ʵ�壺�����
class LeaveRequest {
    private String name;
    private int days;

    public LeaveRequest(String name, int days) {
        this.name = name;
        this.days = days;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void getInfo() {
        System.out.print("�����Ϣ:");
        System.out.println("{Ա��:" + this.name + " / ����:" + this.days + "}");
    }
}

/********************************************************************
* ��ɫ���ࣺ
* 1.��������(Handler)
* 2.���崦����(ConcreteHandler)
* 3.����ʵ��  (Request)
*********************************************************************/
abstract class AbsHandler {
    AbsHandler nextHandler;

    public void setNextHandler(AbsHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    abstract void handleRequest(int weight);
}

class SmallTrack extends AbsHandler {

    @Override
    void handleRequest(int weight) {
        if (weight > 0 && weight <= 100) {
            System.out.println("SmallTrack --> handleRequest()");
        } else {
            this.nextHandler.handleRequest(weight);
        }
    }
}

class MiddleTrack extends AbsHandler {

    @Override
    void handleRequest(int weight) {
        if (weight > 100 && weight <= 300) {
            System.out.println("MiddleTrack --> handleRequest()");
        } else {
            this.nextHandler.handleRequest(weight);
        }
    }
}

class BigTrack extends AbsHandler {

    @Override
    void handleRequest(int weight) {
        if (weight > 300 && weight <= 500) {
            System.out.println("BigTrack --> handleRequest()");
        } else {
            System.out.println("goods are overload, there is no track can handler the request.....");
        }
    }
}

class Test {
    public static void main(String[] args) {
        AbsHandler smallTrack = new SmallTrack();
        AbsHandler middleTrack = new MiddleTrack();
        AbsHandler bigTrack = new BigTrack();
        smallTrack.setNextHandler(middleTrack);
        middleTrack.setNextHandler(bigTrack);

        smallTrack.handleRequest(50);
        smallTrack.handleRequest(200);
        smallTrack.handleRequest(390);
        smallTrack.handleRequest(999);
    }
}