package pac13_Lambda;

/**
 * @project: Java_Study
 * @author: F.C.Tang
 * @date: 2020-09-22 21:33
 * @desc: 关于变量引用时的final声明
 *
 *
 * 实际上编译后的内部类的构造方法的里面，传了对应的外部类的引用和所有局部变量的
 * 形参。（由于外部类方法执行完后局部变量会消亡，所以内部类构造函数中的局部变量
 * 实际是一份“复制”。而为了访问外部类中的私有成员变量，外部类编译后也产生了访问
 * 类似与getX()的方法。）
 *
 * 如果局部变量不设为final，内部类构造完毕后，外部类的局部变量又改变了,会产生
 * 一个不一致的问题。
 *
 **/
public class T07_Final {

    public static void main(String[] args) {
        new Out().test("hi");
    }

}

class Out {

    /**
    * 解决方案:
     * 1.final修饰, 以此拷贝一份变量(发生修改时不会影响)
     * 2.代码中不再重赋值或重引用
     *
    * */
    public void test(String a) {

        class In {
            public void function() {
                System.out.println(a);
            }
        }
        // Error:(19, 36)
        // java: 从内部类引用的本地变量必须是最终变量,或实际上的最终变量
        // 注释此行则不会报错
        //a = "hello";
        new In().function();
    }

}