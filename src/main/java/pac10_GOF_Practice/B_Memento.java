package pac10_GOF_Practice;

import java.util.Stack;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-07 10:55
 * @note: 备忘录模式
 *
 *  3.角色分类
 *  （1）Originator(源发器：被保存对象)
 *  （2）Memento   (备忘录类：存储对象的拷贝)
 *  （3）CareTaker (负责人类：集中存储、管理备忘录对象)
 *
 **/
public class B_Memento {
    public static void main(String[] args) {
        Student student = new Student(10, "name1");
        CareTaker taker = new CareTaker();
        System.out.println("原始数据:");
        student.printInfo();

        //第1次备份
        taker.pushMemento(student.createMemento());
        //第1次修改数据
        System.out.println("\n执行修改操作:");
        student.setAge(20);
        student.setName("name2");
        student.printInfo();
        //第2次备份
        taker.pushMemento(student.createMemento());
        //第2次修改数据
        System.out.println("执行修改操作:");
        student.setAge(30);
        student.setName("name3");
        student.printInfo();
        System.out.println();
        //恢复第2次备份的数据
        student.recovery(taker.getPeekMemento());
        student.printInfo();
        //恢复第1次备份的数据
        student.recovery(taker.getPeekMemento());
        student.printInfo();

    }
}

class Student {
    int age;
    String name;
    Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Memento createMemento(){
        return new Memento(this);
    }
    public void recovery/*setMemento*/(Memento memento) {
        System.out.println("执行恢复操作...");
        this.age = memento.getAge();
        this.name = memento.getName();
    }
    public void printInfo() {
        System.out.print("当前数据 [ ");
        System.out.print("年龄：" + age);
        System.out.println(" , 姓名：" + name + " ]");
    }
}

class Memento {
    private int age;
    private String name;

    Memento(Student student) {
        this.age = student.getAge();
        this.name = student.getName();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class CareTaker{
    Stack<Memento> mementoList = new Stack<>();

    public void pushMemento(Memento memento){
        this.mementoList.add(memento);
    }
    public Memento getPeekMemento(){
        return mementoList.pop();
    }
    public void removePopMemento() {
        if (!this.mementoList.empty())
            this.mementoList.pop();
    }
}