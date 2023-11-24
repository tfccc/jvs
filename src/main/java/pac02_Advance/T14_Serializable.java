package pac02_Advance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.*;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-27 19:58
 * @desc: Java Serializable机制
 *
 * 序列化: 写对象
 * 反序列化: 读对象
 *
 * 1、序列化的作用
 *   为了保存在内存中的各种对象的状态（也就是实例变量,不是方法）,并且
 *   可以把保存的对象状态再读出来。虽然你可以用你自己的各种各样的方法
 *   来保存object states，但是Java给你提供一种应该比你自己好的保存对
 *   象状态的机制，那就是序列化。
 *   简而言之:
 *   序列化的作用就是为了不同jvm之间共享实例对象的一种解决方案由java
 *   提供此机制,效率之高,是其他解决方案无法比拟的.
 *
 * 2、序列化应用场景
 *   (a)把的内存中的对象状态保存到一个文件中或者数据库中的时候
 *   (b)用套接字在网络上传送对象的时候
 *   (c)通过RMI传输对象的时候
 *
 * 3.说明
 *   (a)被序列化对象需要实现Serializable接口
 *
 **/
public class T14_Serializable {
    private static File file = new File("F:/1.WorkSpaces/IDEA_2019.2.4/Java_Study/src/pac00_outPut/Bean_Persons.out");

    @Test
    @DisplayName("测试样例")
    public void test() throws Exception {
        writeObj();
        reaObj();
    }

    /**写入对象到文件*/
    private static void writeObj() throws Exception {
        ObjectOutputStream oOut = new ObjectOutputStream(
                                    new FileOutputStream(file));
        Person p1 = new Person("John", 20, Gender.MALE);
        Person p2 = new Person("Andy", 19, Gender.MALE);
        Person p3 = new Person("Jack", 22, Gender.FEMALE);
        oOut.writeObject(p1);
        oOut.writeObject(p2);
        oOut.writeObject(p3);
        oOut.writeObject(null); //防止读取到末尾抛出异常
        oOut.close();
        System.out.println("写入到文件---->" + file.getName());
    }

    /**读取对象*/
    private static void reaObj() throws Exception {
        System.out.println("从文件读取对象-->" + file.getName());
        ObjectInputStream oIn = new ObjectInputStream(
                new FileInputStream(file));
        Person obj;
        while ((obj = (Person) oIn.readObject()) != null) {
            System.out.println(obj);
        }
        oIn.close();
        System.out.println("读取结束");
    }
}

enum Gender {MALE, FEMALE}

class Person implements Serializable {

    private String name = null;

    private Integer age = null;

    private Gender gender = null;

    public Person() {
    }

    public Person(String name, Integer age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "[" + name + ", " + age + ", " + gender + "]";
    }
}