package pac02_Advance;

import lombok.Data;
import org.apache.kafka.common.annotation.InterfaceStability;
import org.junit.jupiter.api.Test;
import pac01_Basics.Annotation01;
import pac01_Basics.Annotation02;
import java.util.*;

/**
 * @project: Java_Study
 * @author: Tang.F.C
 * @date: 2020-01-23 21:40
 * @desc: ComparatorӦ��
 *
 * 1.���ö���ӵ��ָ����������
 * 2.��Ҫ���ڱȽ�����
 * 3.�ټ������ʱ��������
 *
 **/
public class T11_Comparator {
    public static void main(String[] args) {

    }


    @Test
    //�����Զ���Comparator�����List��������
    public void test1() {
        Comparator<Student> comp = new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getAge(), o2.getAge());
            }
        };
        List<Student> stuList = Arrays.asList(
                new Student(18,"aa"),
                new Student(30,"bb"),
                new Student(20,"cc"),
                new Student(25,"dd")
        );
        stuList.sort(comp);
        for (Student student : stuList)
            System.out.println(student.getName() +
                    ", " + student.getAge());
    }

}

@Data
@InterfaceStability.Unstable
@Annotation01
@Annotation02(columnName = "columnName", type = "type", length = 100)
class Student {
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

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }
}
