package pac14_Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-26 14:37
 * @desc: ����
 *
 * һ.����
 *   1.sorted() : ��Ȼ����(�Դ�����)
 *   2.sorted(Comparator) :��������
 *   3.
 *
 **/
@SuppressWarnings("all")
public class T04_Sort {

    @Test
    @DisplayName("����")
    public void sortNaturally() {
        //1.��Ȼ����
        List<Integer> nums = Arrays.asList(5, 2, 3, 6, 1, 8);
        nums.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println();

        //2.��������
        List<Worker> workers = Worker.getWorkerList();
        workers.stream()
                .sorted((o1, o2) -> o1.getAge() == o2.getAge() ?
                        Integer.compare(o1.getSalary(), o2.getSalary()) :
                        Integer.compare(o1.getAge(), o2.getAge()))
                .forEach(System.out::println);

        /*if (o1.getAge() == o2.getAge()) {
            return;
        } else {
            return;
        }*/
    }

    public static void main(String[] args) {
        List<Worker> workers = Worker.getWorkerList();

        workers.forEach(System.out::println);

        System.out.println();

        workers.stream()
                .sorted((o1, o2) -> o1.getAge() == o2.getAge() ?
                        Integer.compare(o1.getSalary(), o2.getSalary()) :
                        Integer.compare(o1.getAge(), o2.getAge()))
                .forEach(System.out::println);
    }

}
