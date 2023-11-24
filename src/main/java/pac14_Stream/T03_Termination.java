package pac14_Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import utils.Formatter;
import utils.TravelCollection;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-26 14:50
 * @desc: ��ֹ����
 *
 * һ.���������
 *   1.allMatch  //�Ƿ�ƥ������
 *   2.anyMatch  //����ƥ��һ��
 *   3.noneMatch //û��ƥ��Ԫ��
 *   4.findFirst //���ص�һ��
 *   5.findAny   //���ⷵ��һ��
 *   6.count     //Ԫ�ؼ���
 *   7.max       //�������ֵ
 *   8.min       //������Сֵ
 *
 * ��.��Լ
 *   1.reduce    //������Ԫ�ط����������,�õ�һ��ֵ
 *
 * ��.�ռ�
 *   1.collect(Collectors.toList())   //�ռ�Ԫ�ص��б���
 *   2.collect(Collectors.groupingBy) //����
 *   3.collect(Collectors.groupingBy) //����(���㡢������һ��)
 *   4.collect(Collectors.joining)    //����
 *
 **/
@SuppressWarnings("all")
public class T03_Termination {

    @Test
    @DisplayName("һ.��������෽������")
    public void test() {
        /** 1.allMatch() **/
        boolean b1 = Worker.getWorkerList()
                .stream()
                .allMatch(worker -> worker.getAge() == 20);
        System.out.println(b1);

        /** 2.findAny() **/
        Optional<Worker> op1 = Worker.getWorkerList()
                .parallelStream()
                .findAny();
        System.out.println(op1.get());

        /** 3.count() **/
        int count = (int) Worker.getWorkerList()
                .parallelStream()
                .count();
        System.out.println(count);

        /**4.max() **/
        Optional<Worker> op2 = Worker.getWorkerList()
                .stream()
                .max((x, y) -> {
                    return Integer.compare(x.getSalary(), y.getSalary());
                });
        System.out.println(op2.get());
    }

    @Test
    @DisplayName("��.��Լ: ���")
    public void reduction() {
        List<Integer> nums = Arrays.asList(1, 2, 3);
        int sum = nums
                .stream()
                .reduce(0, (x, y) -> x + y);
        System.out.println("�б�ĺ���: " + sum);

        List<Worker> workers = Worker.getWorkerList();
        sum = workers.stream()
                .map(Worker::getSalary)
                .reduce(0, Integer::sum);
        System.out.println("���ʵĺ���: " + sum);
    }


    @Test
    @DisplayName("")
    public void collect1() {
        //1.�����ռ�
        Formatter.printMedially("1.�����ռ�");
        List<Integer> workersSalary = MyFac.getWorkerList2()
                .stream()
                .filter(w -> w.getSalary() >= 3500)
                .sorted((x, y) -> Integer.compare(x.getSalary(), y.getSalary()))
                .map(Worker::getSalary)
                .limit(3)
                .collect(Collectors.toList());
        workersSalary.forEach(System.out::println);

    }

    @Test
    @DisplayName("")
    public void collect2() {
        //2.�ռ�����
        Formatter.printMedially("2.�ռ�����");
        Map<Integer, List<Worker>> workers1 = MyFac.getWorkerList2()
                .stream()
                .filter(w -> w.getSalary() >= 3500)
                .collect(Collectors.groupingBy(Worker::getSalary));
        workers1.entrySet().forEach(System.out::println);
        TravelCollection.travelMap(workers1, true);

    }

    @Test
    @DisplayName("")
    public void collect3() {
        //3.����
        Formatter.printMedially("3.����");
        Map<Boolean, List<Worker>> workerMap = MyFac.getWorkerList2()
                .stream()
                .collect(Collectors.partitioningBy(worker -> worker.getSalary() > 3800));
        TravelCollection.travelMap(workerMap, true);

    }

    @Test
    @DisplayName("")
    public void collect4() {
        //4.����
        Formatter.printMedially("4.����");
        String res = MyFac.getWorkerList2()
                .stream()
                .map(Worker::getName)
                .distinct()
                .collect(Collectors.joining(", "));
        System.out.println(res);
    }

}
