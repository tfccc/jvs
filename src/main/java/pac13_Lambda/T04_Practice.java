package pac13_Lambda;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-25 12:32
 * @desc: ��ϰLambda���ʽ
 *
 * ����:
 *   1.����Collections.sort(), ͨ��ָ������Worker����,
 *     �Ȱ������,������ͬ�ȹ���,Ĭ�Ͻ���
 *
 *   2.(a)��������ʽ�ӿ�,�ӿ�����String getValue(String str)
 *     (b)���巽��,���Խ�һ���ַ���ת���ɴ�д,����Ϊ�����ķ���ֵ
 *     (c)�ٵ��ý�ȡ�ַ���
 *
 *   3.(a)����һ�����������͵ĺ���ʽ�ӿ�,��������Ϊ<T,R>(TΪ����,RΪ����ֵ)
 *     (b)�ӿ�������calculateLong����
 *     (c)������,���÷���,��������long�ĸ�
 *     (d)�ټ����������ĳ˻�
 *
 **/
public class T04_Practice {

    private List<Worker> workerList = Arrays.asList(
            new Worker("aa", 25, 3000),
            new Worker("bb", 30, 4500),
            new Worker("gg", 40, 4500),
            new Worker("cc", 40, 5000),
            new Worker("hh", 50, 5000),
            new Worker("dd", 25, 3500),
            new Worker("ee", 30, 4000),
            new Worker("ff", 35, 4500)
    );

    @Test
    @DisplayName("����1")
    public void requirement1() {
        workerList.sort((w1, w2) -> {
            if (w1.getAge() == w2.getAge())
                return -Integer.compare(w1.getSalary(), w2.getSalary());
            else
                return -Integer.compare(w1.getAge(), w2.getAge());
        });
        workerList.forEach(System.out::println);
    }

    @Test
    @DisplayName("����2")
    public void requirement2() {
        String str = "abc,DEF";
        System.out.println(convert(str, s -> s.toUpperCase()));
    }

    private String convert(String str, LetterConverter converter) {
        return converter.getValue(str);
    }

    @Test
    @DisplayName("����3")
    public void requirement3() {
        Long a = 100L;
        Long b = 30L;
        System.out.println(doCalculator(a, b, (n1, n2) -> n1 + n2));
        System.out.println(doCalculator(a, b, (n1, n2) -> n1 * n2));
    }

    private Long doCalculator(Long n1, Long n2, LongCalculator calculator) {
        return calculator.calculateLong(n1, n2);
    }

}

/** ����2:�ӿ� */
@FunctionalInterface
interface LetterConverter {
    String getValue(String str);
}

/** ����3:�ӿ� */
@FunctionalInterface
interface LongCalculator {
    Long calculateLong(long n1, long n2);
}