package pac13_Lambda;

import java.util.Arrays;
import java.util.List;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-23 21:35
 * @desc: Bean:员工信息类
 **/
public class Worker {
    private String name;
    private int age;
    private int salary;

    public Worker() {
    }
    public static void main(String[] args) {
        List<Worker> list = Arrays.asList(
                new Worker()
        );
        list.stream().forEach(System.out::println);
    }

    public Worker(int age) {
        this.age = age;
    }

    public Worker(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public static List<Worker> getWorkerList() {
        return Arrays.asList(
                new Worker("OVO", 25, 3000),
                new Worker("TAT", 28, 3500),
                new Worker("UAU", 40, 5000),
                new Worker("QAQ", 22, 3200),
                new Worker("MOM", 30, 4000),
                new Worker("XOX", 35, 4500),
                new Worker("XOX", 20, 3500),
                new Worker("XOX", 20, 3500)
        );
    }

    @Override
    public String toString() {
        return "[" + this.getName() + ", "
                + this.getAge() + ", " +
                +this.getSalary() + "]";
    }
}
