package pac14_Stream;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-23 21:35
 * @desc: Bean:员工信息类
 **/
class Worker {
    private String name;
    private String city;
    private int age;
    private int salary;
    private int entry;

    public Worker(String name, int age, int salary, String city, int entry) {
        this.salary = salary;
        this.entry = entry;
        this.name = name;
        this.city = city;
        this.age = age;
    }

    public Worker(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public Worker() { }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getEntry() {
        return entry;
    }

    public void setEntry(int entry) {
        this.entry = entry;
    }

    public Worker(int age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "[" + this.getName() + ", "
                + this.getAge() + ", "
                + this.getSalary() + ", "
                + this.getCity() + ", "
                + this.getEntry() + "]";
    }

    public static List<Worker> getWorkerList() {
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


    /**********************************************************
     *        Stream.distinct()需要重写equals()和hashCode()
     ***********************************************************/
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return age == worker.age &&
                salary == worker.salary &&
                name.equals(worker.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }
}
