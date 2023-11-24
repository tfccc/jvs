package pac01_Basics;

/**
 * @author TFC
 * @date 2019��6��15�� ����10:19:54
 * @note ö�ٲ���
 *
 * 1.enum�൱��һ���࣬��ų�Ա�����������Ķ���ʹ��
 * 2.��Ա����Ĭ������public static final
 *
 */
public class T07_Enum {

    enum WeekDay {
        ����һ("����һ"),
        ���ڶ�("���ڶ�"),
        ������("������"),
        ������("������"),
        ������("������"),
        ������("������"),
        ������("������");

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

        System.out.println(WeekDay.���ڶ�);
        WeekDay d1 = WeekDay.����һ;
        WeekDay d2 = WeekDay.���ڶ�;
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