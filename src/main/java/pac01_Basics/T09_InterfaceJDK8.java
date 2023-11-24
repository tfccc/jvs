package pac01_Basics;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-15 20:32
 * @desc: JDK8�ӿ�������
 *
 * �����ԣ�
 *   1.Ĭ�Ϸ���
 *   2.��̬����
 *
 **/
public interface T09_InterfaceJDK8 {

    //1.Ĭ�Ϸ���
    default int defaultMethod(){
        System.out.println("defaultMethod");
        return 1;
    }
    //2.��̬����
    static void staticMethod(){
        System.out.println("staticMethod");
    }
    //3.jdk8֮ǰ
    void oldMethod();

}

class Implementor implements T09_InterfaceJDK8 {

    public static void main(String[] args) {
        Implementor implementor = new Implementor();
        implementor.defaultMethod();
        T09_InterfaceJDK8.staticMethod();
    }

    @Override
    public void oldMethod() {

    }
}
