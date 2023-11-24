package pac14_Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import utils.Formatter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-27 12:29
 * @desc: Stream��ϰ
 *
 * ����:
 *   1.����һ������, ����һ�������ֵ�ƽ����ɵ��б�
 *   2.ͳ�������ж��ٸ�Work����
 *   3.�����б�
 *
 **/
@SuppressWarnings("")
public class T05_Practice {

    @Test
    @DisplayName("����1")
    public void req1() {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Arrays.stream(nums)
                .map((n) -> n * n)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("����2")
    public void req2() {
        List<Worker> workers = MyFac.getWorkerList1();
        Optional<Integer> c1 = workers.stream()
                .map(worker -> 1)
                .reduce(Integer::sum);
        long c2 = workers.stream().count();
        System.out.println(c1.get());
        System.out.println(c2);
    }

    @Test
    @DisplayName("����3")
    public void req3() {
        //1
        Formatter.printMedially("1Ա������Щ���й���");
        List<Worker> workers = MyFac.getWorkerList2();
        workers.stream()
                .map(Worker::getCity)
                .distinct()
                .forEach(System.out::println);

        //2
        Formatter.printMedially("2.�����������Ա��,��������������");
        workers.stream()
                .filter(worker -> worker.getCity().equals("����"))
                .sorted(Comparator.comparing(Worker::getName))
                .forEach(System.out::println);

        //3
        Formatter.printMedially("3.��û��Ա�������Ϻ�");
        boolean res = workers.stream()
                .anyMatch(worker -> worker.getCity().equals("�Ϻ�"));
        System.out.println(res);

        //4
        Formatter.printMedially("4.������������Ա���Ĺ���");
        Optional<Integer> op1 = workers.stream()
                .filter(worker -> worker.getCity().equals("����"))
                .map(Worker::getSalary)
                .reduce(Integer::sum);
        System.out.println(op1.get());

        //5
        Formatter.printMedially("5.�����˹��ʵ����ֵ");
        Optional<Integer> max = workers.stream()
                .map(Worker::getSalary)
                .max(Integer::compareTo);
        System.out.println(max.get());
    }

}
