package pac00_Test;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Frank.Tang
 * @date 2023-09-26 10:09
 * @desc
 **/
public class JdkNewFeature17 {

    public static void main(String[] args) {
        //switchArrow();
        //switchYield();
        //textFiled();
        //recordClass();

    }

    /** var */
    public static void varFiled() {
        var integer = 21;
        var string = "str";
        var arr0 = new int[10];
        var arr1 = new String[5];
        var hashmap = new HashMap<String, String>();
        var aInteger = new AtomicInteger(10);
    }

    /** switch 箭头表达式 */
    public static void switchArrow() {
        int week = 7;
        String memo = "";
        switch (week) {
            case 1, 2, 3, 4, 5 -> memo = "工作日";
            case 6, 7 -> memo = "休息日";
            default -> throw new RuntimeException("无效的日期");
        }
        System.out.println(memo);
    }

    /** switch 返回值 */
    public static void switchYield() {
        int week = 4;
        String memo = switch (week) {
            case 1, 2, 3, 4, 5 -> {
                System.out.println(2);
                yield "工作日";
            }
            case 6, 7 -> {
                System.out.println(2);
                yield "休息日";
            }
            default -> throw new RuntimeException("无效的日期");
        };
        System.out.println(memo);
    }


    /** 文本块 */
    public static void textFiled() {
        String str = """
                select *
                from table
                where name = #{name}
                """;
    }

    /** record类 */
    public static void recordClass() {
        RecordClass frank = new RecordClass(10, "frank", 20);
        RecordClass tommy = new RecordClass();
        Integer age = frank.age();
        RecordClass.sMethod();
        frank.iMethod();
        String staticFiled = RecordClass.STATIC_FILED;
        tommy.getClass().isRecord();
    }

}


/*****************************************************************
 *                          Record类
 * 1.带有全部参数的构造方法
 * 2.public访问器
 * 3.toString()、hashCode()、equals()
 * 4.无set、get方法，没有遵循Bean的命名规范
 * 5.final类，不能继承Record，Record为隐式的final类，除此之外与普通类一样
 * 6.不可变类，通过构造创建Record
 * 7.final属性不可修改
 * 8.不能声明实例属性，能声明static成员
 *****************************************************************/
record RecordClass(Integer id, String name, Integer age) {
    /** 紧凑型构造方法(扩展默认构造器) */
    RecordClass {
        if (id < 1000) {
            throw new RuntimeException("id<1000");
        }
    }

    /** 自定义构造器 */
    public RecordClass() {
        this(null, null, null);
    }

    /** 静态成员变量 */
    public static final String STATIC_FILED = "SF";

    /** 静态方法 */
    public static void sMethod() {

    }

    /** 实例方法 */
    public void iMethod() {

    }
}


/*****************************************************************
 *                          密封类
 *****************************************************************/
sealed class Demo permits Child, NoSealedChild {
}

/**
 * 密封类的子类，默认同样是密封类，必须带 final 关键字，表示不能再被继承
 */
final class Child extends Demo {
}

/**
 * 密封类的子类，通过non-sealed设定为非密封类，可以再被继承
 */
non-sealed class NoSealedChild extends Demo {
}

/**
 * 密封类子类，并且是非密封类，就可以再被下面的类继承
 */
class Grandchild extends NoSealedChild {

}