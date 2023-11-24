package pac09_GOF;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-12 10:31
 * @note: 外观模式(迪米特法则：一个实体尽量少于另一个实体发生相互作用)
 *
 * *应用场景：系统功能封装，外部通过简单的接口调用内部复杂方法。
 *
 * *0.把子系统的功能整合到主系统里面，集中管理。
 * *1.为系统提供统一的入口,减少了系统的相互依赖，调用者只需和入口打交道。
 * *2.封装系统的复杂性，便于沟通、调用。
 * *3.提高了安全性、灵活性。
 *
 * 角色分类：
 * 1.主系统 (封装子系统的内部复杂性,外部通过和主系统打交道,来间接访问子系统)
 * 2.子系统 (由多个系统组成)
 * 3.客户端 (外部访问对象)
 *
 * 实际运用：
 * 1.springJD
 **/
public class T11_Facade {
    public static void main(String[] args) {
        //3.客户调用
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
        facade.methodC();
        facade.methodD();
    }
}

//1.主系统
class Facade {
    //委托的子系统对象
    private SubSystemA a;
    private SubSystemB b;
    private SubSystemC c;
    private SubSystemD d;
    Facade() {
        a = new SubSystemA();
        b = new SubSystemB();
        c = new SubSystemC();
        d = new SubSystemD();
    }
    //提供给外部访问的方法
    void methodA() {
        this.a.doSomethingA();
    }
    void methodB() {
        this.b.doSomethingB();
    }
    void methodC() {
        this.c.doSomethingC();
    }
    void methodD() {
        this.d.doSomethingD();
    }

}
//2.子系统
class SubSystemA {
    void doSomethingA() {
        System.out.println("子系统--方法A");
    }
    void methodNotShow() {
        System.out.println("不通过外观模式展示的方法");
    }
}
class SubSystemB {
    void doSomethingB() {
        System.out.println("子系统--方法B");
    }
    void methodNotShow() {
        System.out.println("不通过外观模式展示的方法");
    }
}
class SubSystemC {
    void doSomethingC() {
        System.out.println("子系统--方法C");
    }
}
class SubSystemD {
    void doSomethingD() {
        System.out.println("子系统--方法D");
    }
}