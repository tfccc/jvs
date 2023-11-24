package pac02_Advance;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.*;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-27 19:58
 * @desc: Java Serializable����
 *
 * ���л�: д����
 * �����л�: ������
 *
 * 1�����л�������
 *   Ϊ�˱������ڴ��еĸ��ֶ����״̬��Ҳ����ʵ������,���Ƿ�����,����
 *   ���԰ѱ���Ķ���״̬�ٶ���������Ȼ����������Լ��ĸ��ָ����ķ���
 *   ������object states������Java�����ṩһ��Ӧ�ñ����Լ��õı����
 *   ��״̬�Ļ��ƣ��Ǿ������л���
 *   �����֮:
 *   ���л������þ���Ϊ�˲�ͬjvm֮�乲��ʵ�������һ�ֽ��������java
 *   �ṩ�˻���,Ч��֮��,��������������޷������.
 *
 * 2�����л�Ӧ�ó���
 *   (a)�ѵ��ڴ��еĶ���״̬���浽һ���ļ��л������ݿ��е�ʱ��
 *   (b)���׽����������ϴ��Ͷ����ʱ��
 *   (c)ͨ��RMI��������ʱ��
 *
 * 3.˵��
 *   (a)�����л�������Ҫʵ��Serializable�ӿ�
 *
 **/
public class T14_Serializable {
    private static File file = new File("F:/1.WorkSpaces/IDEA_2019.2.4/Java_Study/src/pac00_outPut/Bean_Persons.out");

    @Test
    @DisplayName("��������")
    public void test() throws Exception {
        writeObj();
        reaObj();
    }

    /**д������ļ�*/
    private static void writeObj() throws Exception {
        ObjectOutputStream oOut = new ObjectOutputStream(
                                    new FileOutputStream(file));
        Person p1 = new Person("John", 20, Gender.MALE);
        Person p2 = new Person("Andy", 19, Gender.MALE);
        Person p3 = new Person("Jack", 22, Gender.FEMALE);
        oOut.writeObject(p1);
        oOut.writeObject(p2);
        oOut.writeObject(p3);
        oOut.writeObject(null); //��ֹ��ȡ��ĩβ�׳��쳣
        oOut.close();
        System.out.println("д�뵽�ļ�---->" + file.getName());
    }

    /**��ȡ����*/
    private static void reaObj() throws Exception {
        System.out.println("���ļ���ȡ����-->" + file.getName());
        ObjectInputStream oIn = new ObjectInputStream(
                new FileInputStream(file));
        Person obj;
        while ((obj = (Person) oIn.readObject()) != null) {
            System.out.println(obj);
        }
        oIn.close();
        System.out.println("��ȡ����");
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