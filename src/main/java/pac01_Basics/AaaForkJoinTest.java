package pac01_Basics;

import bean.Student;
import lombok.Data;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @project: Java_Study
 * @author: Frank.Tang
 * @date: 2021-08-07 21:35
 * @desc:
 **/
public class AaaForkJoinTest {


    public static void main(String[] args) throws InterruptedException, ExecutionException {
        m1();

       // m2();

    }
    private static int size = 10_0000;
    private static int num = 100_0000;


    private static void m1() throws InterruptedException, ExecutionException {
        long sTime = System.currentTimeMillis();

        List<Student> res = new ArrayList<>();
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            students.add(new Student());
        }

        int count = students.size() / size;

        for (int i = 1; i <= count; i++) {
            List<Student> subList = students.subList((i - 1) * size, i * size);
            FutureTask<List<Student>> task = new FutureTask<>(new TestClass(subList));
            Thread thread = new Thread(task);
            Cache.set1.add(thread.getName());
            thread.start();

            res.addAll(task.get());
        }

        //System.out.println("m1 -- res.size() = " + res.size());
        //System.out.println(res);
        long eTime = System.currentTimeMillis();
        System.out.println("耗时: " + (eTime - sTime) + "ms");
    }

    private static void m2() {
        long sTime = System.currentTimeMillis();
        List<Student> students = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            students.add(new Student());
        }

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            student.setAge(i);
            student.setName("tfc");
        }

        //System.out.println("m2 -- students.size() = " + students.size());
        long eTime = System.currentTimeMillis();
        System.out.println("执行完成2, 耗时: " + (eTime - sTime) + "ms");

    }

}


@Data
class TestClass implements Callable<List<Student>> {

    private List<Student> students;

    public TestClass(List<Student> students) {
        this.students = students;
    }

    @Override
    public List<Student> call() {
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            student.setAge(i);
            student.setName("tfc");
        }
        return students;
    }
}


class Cache {
    public static final Set<String> set1 = new HashSet<>();
    public static final Set<String> set2 = new HashSet<>();

}
