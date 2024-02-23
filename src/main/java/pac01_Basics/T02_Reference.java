package pac01_Basics;

import scala.ref.PhantomReference;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2020-01-08 11:38
 * @note: Java引用机制测试
 *
 *        1.强引用: 内存不足的情况下，垃圾回收器也不会回收该对象
 *        2.软引用: 当系统内存不足时+没有引用，垃圾回收器可能会回收该对象
 *        3.弱引用: 不论内存是否充足+没有引用，都会回收该对象
 *        4.虚引用: 随时可能被垃圾回收器回收
 *
 **/
public class T02_Reference {
    public static void main(String[] args) {
        Person2 person=new Person2();
        person.setAge(10);
        person.setName("tfc");
        person.printInfo();

        PersonsReference reference = new PersonsReference(person);
        //PersonsReference reference = new PersonsReference(new Person());

        reference.printInfo();
        //改变其中一个的值，两个变量都要改变
        //person.setAge(20);
        reference.person.setAge(20);

        System.out.println("---------------");
        person.printInfo();
        reference.printInfo();


        //SoftReference;
        //WeakReference;
        //PhantomReference;
    }
}

class Person2{
    private int age;
    private String name;

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
    public void printInfo() {
        System.out.println(this.getAge() + "/" + this.getName());
    }
}

class PersonsReference {
    public Person2 person;

    public PersonsReference(Person2 person) {
        this.person = person;
    }

    public void printInfo() {
        System.out.println(person.getAge() + "/" + person.getName());
    }
}