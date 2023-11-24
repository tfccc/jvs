package pac10_GOF_Practice;


/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-06 20:24
 * @note: 责任链模式
 *
 * 角色分类：
 *  1.抽象处理者(Handler)
 *  2.具体处理者(ConcreteHandler)
 *  3.请求实体  (Request)
 *
 **/
public class B_ChainOfResponsibility {
    public static void main(String[] args) {
        Leader leader_ProjectLeader = new projectLeader();
        Leader leader_Manager       = new Manager();
        Leader leader_Boss          = new Boss();

        leader_ProjectLeader.setNextLeader(leader_Manager);
        leader_Manager.setNextLeader(leader_Boss);

        leader_ProjectLeader.handleReq(5);
    }
}

abstract class Leader {
    Leader nextLeader;

    void setNextLeader(Leader leader){
        this.nextLeader=leader;
    }

    abstract void handleReq(int days);

}

class projectLeader extends Leader{
    @Override
    void handleReq(int days) {
        if(days<=3){
            System.out.println("审批人：项目组长");
            System.out.println("请假天数："+days);
        }else {
            this.nextLeader.handleReq(days);
        }
    }
}

class Manager extends Leader{
    @Override
    void handleReq(int days) {
        if(days<=10){
            System.out.println("审批人：项目经理");
            System.out.println("请假天数："+days);
        }else {
            this.nextLeader.handleReq(days);
        }
    }
}

class Boss extends Leader{
    @Override
    void handleReq(int days) {
        if(days<=20){
            System.out.println("审批人：项目经理");
            System.out.println("请假天数："+days);
        }else {
            System.out.println("Too Many LeaveDays, You Are Fired!!!");
        }
    }
}