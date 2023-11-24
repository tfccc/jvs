package pac01_Basics;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-15 20:32
 * @desc: JDK8接口新特性
 *
 * 新特性：
 *   1.默认方法
 *   2.静态方法
 *
 **/
public interface T09_InterfaceJDK8 {

    //1.默认方法
    default int defaultMethod(){
        System.out.println("defaultMethod");
        return 1;
    }
    //2.静态方法
    static void staticMethod(){
        System.out.println("staticMethod");
    }
    //3.jdk8之前
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
