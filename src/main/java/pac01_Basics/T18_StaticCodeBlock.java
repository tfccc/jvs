package pac01_Basics;

/**
 * @program: Java_Study
 * @author: TFC
 * @date: 2019-12-27 22:33
 * @note: 静态代码块
 *
 *  执行顺序：静态代码块 > 构造代码块 > 构造函数 > 普通代码块　
 *
 *  作用:主要用于初始化类,对象等
 *
 **/
public class T18_StaticCodeBlock {

    //优先于其它代码执行，多用于初始加载配置文件等
    static {
        System.out.println("1.静态代码块输出");
    }

    //需构造代码块，实例化类对象后才会执行
    {
        System.out.println("3.普通代码块输出");
    }

    public static void main(String[] args) {
        System.out.println("2.主函数输出");
        T18_StaticCodeBlock scb = new T18_StaticCodeBlock();

    }

    //Constructor
    private T18_StaticCodeBlock() {
        System.out.println("4.构造器初始化对象");
    }
}
