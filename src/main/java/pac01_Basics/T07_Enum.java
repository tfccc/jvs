package pac01_Basics;

/**
 * @author TFC
 * @date 2019年6月15日 上午10:19:54
 * @note 枚举测试
 *
 * 1.enum相当于一个类，存放成员变量，方便阅读和使用
 * 2.成员变量默认类型public static final
 *
 */
public class T07_Enum {

    enum WeekDay {
        星期一("星期一"),
        星期二("星期二"),
        星期三("星期三"),
        星期四("星期四"),
        星期五("星期五"),
        星期六("星期六"),
        星期日("星期日");

        private String name;

        WeekDay(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {

        System.out.println(WeekDay.星期二);
        WeekDay d1 = WeekDay.星期一;
        WeekDay d2 = WeekDay.星期二;
        System.out.println(d1);
        System.out.println(d2);

    }
}


enum E {
    E1, E2(20, "tfc");
    private int age;
    private String name;

    E() { }

    E(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "E{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public static void main(String[] args) {
        E e2 = E.E2;
        E e1 = E.E1;
        System.out.println(e1);
        System.out.println(e2);
    }
}