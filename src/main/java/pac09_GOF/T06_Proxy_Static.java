package pac09_GOF;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-06 09:42
 * @note: 静态代理: 代理对象已先编写好
 *
 * *1.核心作用：通对代理，控制对象的访问。可详细控制访问某个对象的方法，
 *    在调用前后分别做前、后置处理。
 * *2.代理模式(动态代理)为AOP编程的核心机制。
 *
 * 角色分类：
 *   1.抽象角色：定义代理角色和真实角色的公共对外方法。
 *   2.真实角色：定义真实角色需实现的业务逻辑，供代理角色调用。
 *   3.代理角色：代理真实角色，实现另外的业务逻辑。
 *
 **/
public class T06_Proxy_Static {
    public static void main(String[] args) {
        AbstractRole star = new Star();
        AbstractRole agent = new Agent(star);
        agent.confer();
        agent.singContract();
        agent.confer();
    }
}

//1.抽象角色
interface AbstractRole {
    //1,2,4由代理角色完成, 3由真实角色完成。
    void confer();          //1.面谈
    void singContract();    //2.签合同
    void show();            //3.演出
    void checkOut();        //4.结款
}

//2.真实角色(明星)
class Star implements AbstractRole {
    @Override
    public void confer() {
        System.out.println("明星--->面谈");
    }

    @Override
    public void singContract() {
        System.out.println("明星--->签合同");
    }

    @Override
    public void show() {
        System.out.println("明星--->演出");
    }

    @Override
    public void checkOut() {
        System.out.println("明星--->收款");
    }
}

//3.代理角色(经纪人)
class Agent implements AbstractRole {
    private AbstractRole star;

    Agent(AbstractRole star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("经纪人-->面谈");
    }

    @Override
    public void singContract() {
        System.out.println("经纪人-->签合同");
    }

    //请求真实角色实现show方法
    @Override
    public void show() {
        star.show();
    }

    @Override
    public void checkOut() {
        System.out.println("经纪人-->收款");
    }
}

