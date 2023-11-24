package pac10_GOF_Practice;

import java.util.Stack;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-07 10:55
 * @note: ����¼ģʽ
 *
 *  3.��ɫ����
 *  ��1��Originator(Դ���������������)
 *  ��2��Memento   (����¼�ࣺ�洢����Ŀ���)
 *  ��3��CareTaker (�������ࣺ���д洢��������¼����)
 *
 **/
public class B_Memento {
    public static void main(String[] args) {
        Student student = new Student(10, "name1");
        CareTaker taker = new CareTaker();
        System.out.println("ԭʼ����:");
        student.printInfo();

        //��1�α���
        taker.pushMemento(student.createMemento());
        //��1���޸�����
        System.out.println("\nִ���޸Ĳ���:");
        student.setAge(20);
        student.setName("name2");
        student.printInfo();
        //��2�α���
        taker.pushMemento(student.createMemento());
        //��2���޸�����
        System.out.println("ִ���޸Ĳ���:");
        student.setAge(30);
        student.setName("name3");
        student.printInfo();
        System.out.println();
        //�ָ���2�α��ݵ�����
        student.recovery(taker.getPeekMemento());
        student.printInfo();
        //�ָ���1�α��ݵ�����
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
        System.out.println("ִ�лָ�����...");
        this.age = memento.getAge();
        this.name = memento.getName();
    }
    public void printInfo() {
        System.out.print("��ǰ���� [ ");
        System.out.print("���䣺" + age);
        System.out.println(" , ������" + name + " ]");
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