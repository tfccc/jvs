package pac14_Stream;

import java.util.Arrays;
import java.util.List;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-27 12:56
 * @desc: 常用数组、容器对象工厂
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
        String city1 = "重庆";
        String city2 = "上海";
        String city3 = "广东";
        int entryYear1 = 2015;
        int entryYear2 = 2013;
        int entryYear3 = 2017;
        return Arrays.asList(
            new Worker("王晓川", 25, 3000, city2, entryYear1),
            new Worker("吴越", 28, 3500, city3, entryYear1),
            new Worker("李望", 42, 5000, city3, entryYear3),
            new Worker("王欣", 22, 3200, city3, entryYear2),
            new Worker("张宇乐", 22, 3500, city1, entryYear2),
            new Worker("李喜宇", 30, 4000, city2, entryYear2),
            new Worker("唐诗语", 35, 4500, city2, entryYear2),
            new Worker("李学鹏", 20, 3500, city3, entryYear1),
            new Worker("马启越", 28, 4500, city1, entryYear2),
            new Worker("肖金鹏", 25, 2500, city1, entryYear3),
            new Worker("李诺", 21, 5500, city2, entryYear3),
            new Worker("金晓", 36, 5500, city2, entryYear3),
            new Worker("李浩一", 32, 5500, city1, entryYear3)
        );
    }

}
