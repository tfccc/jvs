package pac09_GOF;

/**
 * @program: Java_2019.06.10
 * @author: TFC
 * @date: 2019-09-12 10:31
 * @note: ���ģʽ(�����ط���һ��ʵ�御��������һ��ʵ�巢���໥����)
 *
 * *Ӧ�ó�����ϵͳ���ܷ�װ���ⲿͨ���򵥵Ľӿڵ����ڲ����ӷ�����
 *
 * *0.����ϵͳ�Ĺ������ϵ���ϵͳ���棬���й���
 * *1.Ϊϵͳ�ṩͳһ�����,������ϵͳ���໥������������ֻ�����ڴ򽻵���
 * *2.��װϵͳ�ĸ����ԣ����ڹ�ͨ�����á�
 * *3.����˰�ȫ�ԡ�����ԡ�
 *
 * ��ɫ���ࣺ
 * 1.��ϵͳ (��װ��ϵͳ���ڲ�������,�ⲿͨ������ϵͳ�򽻵�,����ӷ�����ϵͳ)
 * 2.��ϵͳ (�ɶ��ϵͳ���)
 * 3.�ͻ��� (�ⲿ���ʶ���)
 *
 * ʵ�����ã�
 * 1.springJD
 **/
public class T11_Facade {
    public static void main(String[] args) {
        //3.�ͻ�����
        Facade facade = new Facade();
        facade.methodA();
        facade.methodB();
        facade.methodC();
        facade.methodD();
    }
}

//1.��ϵͳ
class Facade {
    //ί�е���ϵͳ����
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
    //�ṩ���ⲿ���ʵķ���
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
//2.��ϵͳ
class SubSystemA {
    void doSomethingA() {
        System.out.println("��ϵͳ--����A");
    }
    void methodNotShow() {
        System.out.println("��ͨ�����ģʽչʾ�ķ���");
    }
}
class SubSystemB {
    void doSomethingB() {
        System.out.println("��ϵͳ--����B");
    }
    void methodNotShow() {
        System.out.println("��ͨ�����ģʽչʾ�ķ���");
    }
}
class SubSystemC {
    void doSomethingC() {
        System.out.println("��ϵͳ--����C");
    }
}
class SubSystemD {
    void doSomethingD() {
        System.out.println("��ϵͳ--����D");
    }
}