package pac15_Keyword;

import bean.Student;
/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2019-12-30 19:32
 * @note: instanceof关键字
 *
 * 1.用来判断一个对象是否为一个类的实例
 *
 **/
public class T01_InstanceOf {

    public static void main(String[] args) {
        String str="123";
        String Null=null;
        Student stu=new Student();

        System.out.println(str instanceof String);
        System.out.println(Null instanceof String);
        System.out.println(stu instanceof Object);
    }

}
