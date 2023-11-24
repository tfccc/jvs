package pac15_Keyword;

/**
 * @author TFC
 * @date 2019年6月15日 上午10:19:54
 * @note 枚举测试
 *
 * 一.说明
 *	 1.enum相当于一个类，存放成员变量，方便阅读和使用
 *	 2.成员变量默认类型public static final
 *
 * 二.作用及优点
 *	 1.增强代码可读性
 *	 2.编译优势:编译时，没有把常量值编译到代码中，即使常量值发生改变，
 *	   也不会影响引用常量的类
 *	 3.修改优势:枚举类编译后默认final class，不允许继承可防止被子类修改
 *	 4.枚举型可直接与数据库交互:使用int、String类型switch时，当出现参数
 *	   不确定的情况，偶尔会出现越界的现象，这样我们就需要做容错操作（if
 *	   条件筛选等），使用枚举，编译期间限定类型，不允许发生越界
 *
 */
public class T07_Enum {

    enum WeekDay {
        星期一, 星期二, 星期三, 星期四, 星期五, 星期六, 星期日,
        ;

        public String getSunday() {
            return String.valueOf(星期日);
        }
    }

    public static void main(String[] args) {

        System.out.println(WeekDay.星期二);
        WeekDay weekDay = WeekDay.星期一;
        System.out.println(weekDay);
        System.out.println(weekDay.getSunday());

    }
}
