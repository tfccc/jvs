package pac14_Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import static utils.Formatter.printMedially;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-26 13:31
 * @desc: �м����
 *
 * һ.��������
 *  ɸѡ����Ƭ:
 *   1.filter  : ����Lambda���ʽ,�������ų�Ԫ��
 *   2.limit(n): �ض���,��������Ԫ������Ϊn
 *   3.skip(n) : ��limit�෴.����ǰn��Ԫ��,����һ��ȥ����ǰn��Ԫ��
 *               ����,������n��,�򷵻�һ������
 *   4.distinct: ����д����hashCode()��equals(),ȥ.���ظ�Ԫ��
 *  ӳ��:
 *   5.map     : (a)����Lambda,��Ԫ��ת����������ʽ,����ȡԪ����Ϣ;
 *               (b)����һ��������Ϊ����,�÷���,�ᱻӦ�õ�ÿ��Ԫ����,
 *               ������ӳ����µ�Ԫ��(������add(),û�кϳɲ���)
 *   6.flatMap : ����һ��������Ϊ����,������ÿ��ֵ��ת��Ϊ��һ����,
 *               Ȼ������������Ӵ�һ����(������addAll()�кϳɲ���)
 *
 *
 **/
@SuppressWarnings("all")
public class T02_Intermediate {

    @Test
    @DisplayName("1.ɸѡ����Ƭ")
    public void screenSlice() {
        /**1.����**/
        printMedially("����");
        List<Worker> workerList = Worker.getWorkerList();
        Stream<Worker> stream1 = workerList.stream()
                .filter((w) -> {
                    System.out.println("�м����");
                    return w.getAge() > 30;
                });
        /**��ֹ����:��ִ����ֹ����,�Żᴥ��������м����
         * (��Ϊ"������ֵ")ע����ֹ����,��������䲻��ִ��*/
        stream1.forEach(System.out::println);

        /**2.��Ƭ**/
        printMedially("����");
        workerList = Worker.getWorkerList();
        stream1 = workerList.stream()
                .filter((w) -> w.getAge() >= 25)
                .limit(2);
        stream1.forEach(System.out::println);

        /**3.����**/
        printMedially("����");
        workerList = Worker.getWorkerList();
        stream1 = workerList.stream()
                .filter((w) -> w.getAge() >= 25)
                .skip(2);
        stream1.forEach(System.out::println);

        /**4.ȥ��**/
        printMedially("����");
        List<Integer> list = Arrays.asList(1, 1, 1, 2, 3, 4, 4, 5, 5);
        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    @DisplayName("2.ӳ��")
    public void mapping() {
        /**1.map**/
        printMedially("map:ת����д");
        List<String> list = Arrays.asList("aa", "Bb", "Cc", "dd", "EE");
        list.stream()
                .map(str -> str.toUpperCase())
                .forEach(System.out::println);

        printMedially("map:��ȡ����");
        Worker.getWorkerList().stream()
                .map(Worker::getName)
                .limit(3)
                .forEach(System.out::println);

        printMedially("map:���շ���(���ɶ����,����϶�)");
        Stream<Stream<Character>> s1 = list.stream()
                .map(T02_Intermediate::convertToChar)
                .limit(2);
        s1.forEach((stream)-> stream.forEach(System.out::println));

        /**2.flatMap**/
        printMedially("flatMap:���շ���(����һ����,��������Ż�)");
        Stream<Character> s2 = list.stream()
                .flatMap(T02_Intermediate::convertToChar)
                .limit(4);
        s2.forEach(System.out::println);
    }

    public static Stream<Character> convertToChar(String str){
        List<Character> list = new ArrayList<>();
        for (Character ch : str.toCharArray()){
            list.add(ch);
        }
        return list.stream();
    }
}
