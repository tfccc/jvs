package pac09_GOF;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-20 12:59
 * @note: 责任链模式:以请假审批为例
 *
 * 实现方式:
 * 1.链式实现(本案例)
 * 2.容器处理(把对象放入容器中，处理请求时，采取遍历容器内对象的形式)
 *
 * *1.定义:将能够处理一类请求的对象连成一条链，按个传递提交的请求，
 *    能则处理，不能处理的则传递给下一个。
 * *2.现实场景:打牌轮流出牌、公司处理请假申请、接力赛跑。
 *
 * 角色分类：
 * 1.抽象处理者(Handler)
 * 2.具体处理者(ConcreteHandler)
 * 3.请求实体  (Request)
 *
 * 应用场景：
 * 1.Java异常机制
 * 2.Servlet过滤器的链式处理
 * 3.Struts2拦截器调用
 **/
public class T13_ChainOfResponsibility {
    public static void main(String[] args) {
        Leader director = new Directors("项目组长");
        Leader manager = new Manager("项目经理");
        Leader boss = new Boss("公司老板");
        //建立上下级关系(形成链关系)
        director.setNextLeader(manager);
        manager.setNextLeader(boss);

        //处理请求(指定级开始)
        LeaveRequest request = new LeaveRequest("tfc", 25);
        director.handleReq(request);
    }
}

/**请假审批案例*/
//1.抽象处理者
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

//2.具体处理者
//2.1:项目组长
class Directors extends Leader {
    public Directors(String name) {
        super(name);
    }

    @Override
    public void handleReq(LeaveRequest request) {
        if (request.getDays() <= 7) {
            System.out.println("审批人:" + this.name + "(0~7)");
            request.getInfo();
        } else {
            if (this.nextLeader != null)
                this.nextLeader.handleReq(request);
        }
    }
}

//2.2:项目经理
class Manager extends Leader {
    public Manager(String name) {
        super(name);
    }

    @Override
    public void handleReq(LeaveRequest request) {
        if (request.getDays() <= 15) {
            System.out.println("审批人:" + this.name + "(8~15)");
            request.getInfo();
        } else {
            if (this.nextLeader != null)
                this.nextLeader.handleReq(request);
        }
    }
}

//2.3:老板
class Boss extends Leader {
    public Boss(String name) {
        super(name);
    }

    @Override
    public void handleReq(LeaveRequest request) {
        if (request.getDays() <= 30) {
            System.out.println("审批人:" + this.name + "(16~30)");
            request.getInfo();
        } else
            System.out.println("请假过长, 直接辞退");
    }
}

//3.请求实体：请假条
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
        System.out.print("请假信息:");
        System.out.println("{员工:" + this.name + " / 天数:" + this.days + "}");
    }
}

/********************************************************************
* 角色分类：
* 1.抽象处理者(Handler)
* 2.具体处理者(ConcreteHandler)
* 3.请求实体  (Request)
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