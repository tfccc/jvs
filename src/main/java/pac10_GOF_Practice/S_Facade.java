package pac10_GOF_Practice;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-06 19:43
 * @note: ���ģʽ
 **/
public class S_Facade {
    public static void main(String[] args) {
        SystemMain systemMain=new SystemMain();

        systemMain.runSystemA_methodA();
        systemMain.runSystemB_methodB();
        systemMain.runSystemC_methodC();
    }
}

class SystemMain {
    private SystemA systemA;
    private SystemB systemB;
    private SystemC systemC;

    public SystemMain() {
        this.systemA = new SystemA();
        this.systemB = new SystemB();
        this.systemC = new SystemC();
    }

    public void runSystemA_methodA(){
        systemA.methdo_A();
    }
    public void runSystemB_methodB(){
        systemB.methdo_B();
    }
    public void runSystemC_methodC(){
        systemC.methdo_C();
    }
}

class SystemA{
    public void methdo_A() {
        System.out.println("1.��ϵͳA-->A����");
    }
}
class SystemB{
    public void methdo_B() {
        System.out.println("2.��ϵͳB-->B����");
    }
}
class SystemC{
    public void methdo_C() {
        System.out.println("3.��ϵͳC-->C����");
    }
}
