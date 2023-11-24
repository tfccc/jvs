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

    /** switch ��ͷ���ʽ */
    public static void switchArrow() {
        int week = 7;
        String memo = "";
        switch (week) {
            case 1, 2, 3, 4, 5 -> memo = "������";
            case 6, 7 -> memo = "��Ϣ��";
            default -> throw new RuntimeException("��Ч������");
        }
        System.out.println(memo);
    }

    /** switch ����ֵ */
    public static void switchYield() {
        int week = 4;
        String memo = switch (week) {
            case 1, 2, 3, 4, 5 -> {
                System.out.println(2);
                yield "������";
            }
            case 6, 7 -> {
                System.out.println(2);
                yield "��Ϣ��";
            }
            default -> throw new RuntimeException("��Ч������");
        };
        System.out.println(memo);
    }


    /** �ı��� */
    public static void textFiled() {
        String str = """
                select *
                from table
                where name = #{name}
                """;
    }

    /** record�� */
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
 *                          Record��
 * 1.����ȫ�������Ĺ��췽��
 * 2.public������
 * 3.toString()��hashCode()��equals()
 * 4.��set��get������û����ѭBean�������淶
 * 5.final�࣬���ܼ̳�Record��RecordΪ��ʽ��final�࣬����֮������ͨ��һ��
 * 6.���ɱ��࣬ͨ�����촴��Record
 * 7.final���Բ����޸�
 * 8.��������ʵ�����ԣ�������static��Ա
 *****************************************************************/
record RecordClass(Integer id, String name, Integer age) {
    /** �����͹��췽��(��չĬ�Ϲ�����) */
    RecordClass {
        if (id < 1000) {
            throw new RuntimeException("id<1000");
        }
    }

    /** �Զ��幹���� */
    public RecordClass() {
        this(null, null, null);
    }

    /** ��̬��Ա���� */
    public static final String STATIC_FILED = "SF";

    /** ��̬���� */
    public static void sMethod() {

    }

    /** ʵ������ */
    public void iMethod() {

    }
}


/*****************************************************************
 *                          �ܷ���
 *****************************************************************/
sealed class Demo permits Child, NoSealedChild {
}

/**
 * �ܷ�������࣬Ĭ��ͬ�����ܷ��࣬����� final �ؼ��֣���ʾ�����ٱ��̳�
 */
final class Child extends Demo {
}

/**
 * �ܷ�������࣬ͨ��non-sealed�趨Ϊ���ܷ��࣬�����ٱ��̳�
 */
non-sealed class NoSealedChild extends Demo {
}

/**
 * �ܷ������࣬�����Ƿ��ܷ��࣬�Ϳ����ٱ��������̳�
 */
class Grandchild extends NoSealedChild {

}