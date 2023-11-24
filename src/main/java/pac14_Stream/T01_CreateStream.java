package pac14_Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-26 12:00
 * @desc: Java8������: Stream�ĸ�Ҫ������Stream
 *
 * һ.˵��������
 *   1.��Ҫ���ڴ�����; ����ִ�в���
 *   2.������; �ɶ���ǿ; �򵥸�Ч
 *   3.ͨ���򵥴����ִ�и��ӵĲ��ҡ����ˡ�ӳ�����ݵȲ���
 *
 * ��.Stream�ĸ���
 *   1.�����������һϵ����ˮ��ʽ�Ĳ���,����һ���µ���
 *   2.���Ϲ�ע���ݱ���,������ע���㡢����
 *   3.Stream�Լ�����洢Ԫ��
 *   4.Stream����ı�ԭ����,���᷵��һ���µ�,���������������
 *   5.Stream�������ӳ�ִ�е�,����ȴ���ֹ����,��ִ��
 *
 * ��.�������輰����
 *   1.����(T01_CreateStream)
 *      (a)ͨ��Collection�ṩ�ĵ�stream()��parallelStream()
 *      (b)ͨ��Arrays��stream()��ȡ������
 *      (c)ͨ��Stream�ӿ��е�of��������
 *      (d)����������
 *
 *   2.�м���� (T02_Intermediate)
 *      (a)filter  : ����Lambda���ʽ,�������ų�Ԫ��
 *      (b)limit(n): �ض���,��������Ԫ������Ϊn
 *      (c)skip(n) : ��limit�෴.����ǰn��Ԫ��,����һ��ȥ����ǰn��Ԫ��
 *                   ����,������n��,�򷵻�һ������
 *      (d)distinct: ����д����hashCode()��equals(),ȥ���ظ�Ԫ��
 *      (e)map     : 1.����Lambda,��Ԫ��ת����������ʽ,����ȡԪ����Ϣ;
 *                   2.����һ��������Ϊ����,�÷���,�ᱻӦ�õ�ÿ��Ԫ����,
 *                   ������ӳ����µ�Ԫ��(������add(),û�кϳɲ���)
 *      (d)flatMap : ����һ��������Ϊ����,������ÿ��ֵ��ת��Ϊ��һ����,
 *                   Ȼ������������ӳ�һ����(������addAll()�кϳɲ���)
 *
 *   3.��ֹ����(T04_Termination):��ִ����ֹ����,�Żᴥ���м����
 *     (��Ϊ"������ֵ")
 *      (a)forEach()�ȷ���
 *      (b)���������
 *          1.allMatch  //�Ƿ�ƥ������
 *          2.anyMatch  //����ƥ��һ��
 *          3.noneMatch //û��ƥ��Ԫ��
 *          4.findFirst //���ص�һ��
 *          5.findAny   //���ⷵ��һ��
 *          6.count     //Ԫ�ؼ���
 *          7.max       //�������ֵ
 *          8.min       //������Сֵ
 *      (c).��Լ
 *          1.reduce    //������Ԫ�ط����������,�õ�һ��ֵ
 *      (d).�ռ�
 *          1.collect(Collectors.toList())   //�ռ�Ԫ�ص�������
 *          2.collect(Collectors.groupingBy) //����
 *          3.collect(Collectors.groupingBy) //����(���㡢������һ��)
 *          4.collect(Collectors.joining)    //����
 *
 **/
@SuppressWarnings("all")
public class T01_CreateStream {

    @Test
    @DisplayName("1.���������ַ���")
    public void create1() {
        //1.ͨ��Collection�ṩ�ĵ�stream()��parallelStream()
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();
        stream1 = list.parallelStream();

        //2.ͨ��Arrays��stream()��ȡ������
        Worker[] workers = new Worker[10];
        Stream<Worker> stream2 = Arrays.stream(workers);

        //3.ͨ��Stream�ӿ��е�of��������
        Stream.of("a", "b", "c", "d");

        //4.����������
        //4.1 ��������
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        stream4.limit(5).forEach(System.out::println);

        //4.1 generate����
        /*Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);*/
    }

    @Test
    @DisplayName("")
    public void test2() {
        Stream<Integer> stream4 = Stream.iterate(0, (x) -> x + 2);
        Object[] objects = stream4.limit(5).toArray();
        for (Object object : objects) {
            System.out.println(object);
        }
    }

    @Test
    @DisplayName("")
    public void test3() {
        int[] integers = new Random()
                .ints(1,11)
                .limit(10)
                .toArray();
        for (int integer : integers) {
            System.out.println(integer);
        }
    }
}
