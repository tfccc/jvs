package pac14_Stream;

import java.util.Arrays;
import java.util.List;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-27 12:56
 * @desc: �������顢�������󹤳�
 *
 **/
public class MyFac {

    public static Integer[] genIntegers() {
        return new Integer[]{1, 2, 3, 4, 5};
    }

    public static String[] genStrings() {
        return new String[]{"aA", "bB", "ccc", "DD", "e"};
    }

    public static Double[] genDoubles() {
        return new Double[]{1.1, 2.2, 30.2, 4.5, 5.6};
    }

    public static List<Worker> getWorkerList1() {
        return Arrays.asList(
                new Worker("OVO", 25, 3000),
                new Worker("TAT", 28, 3500),
                new Worker("UAU", 40, 5000),
                new Worker("QAQ", 22, 3200),
                new Worker("UOU", 22, 3500),
                new Worker("MOM", 30, 4000),
                new Worker("XOX", 35, 4500),
                new Worker("XOX", 20, 3500),
                new Worker("XOX", 20, 3500)
        );
    }

    public static List<Worker> getWorkerList2() {
        String city1 = "����";
        String city2 = "�Ϻ�";
        String city3 = "�㶫";
        int entryYear1 = 2015;
        int entryYear2 = 2013;
        int entryYear3 = 2017;
        return Arrays.asList(
            new Worker("������", 25, 3000, city2, entryYear1),
            new Worker("��Խ", 28, 3500, city3, entryYear1),
            new Worker("����", 42, 5000, city3, entryYear3),
            new Worker("����", 22, 3200, city3, entryYear2),
            new Worker("������", 22, 3500, city1, entryYear2),
            new Worker("��ϲ��", 30, 4000, city2, entryYear2),
            new Worker("��ʫ��", 35, 4500, city2, entryYear2),
            new Worker("��ѧ��", 20, 3500, city3, entryYear1),
            new Worker("����Խ", 28, 4500, city1, entryYear2),
            new Worker("Ф����", 25, 2500, city1, entryYear3),
            new Worker("��ŵ", 21, 5500, city2, entryYear3),
            new Worker("����", 36, 5500, city2, entryYear3),
            new Worker("���һ", 32, 5500, city1, entryYear3)
        );
    }

}
