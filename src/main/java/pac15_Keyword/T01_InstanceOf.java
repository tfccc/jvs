package pac15_Keyword;

import bean.Student;
/**
 * @project: Java_Study
 * @author: TFC
 * @date: 2019-12-30 19:32
 * @note: instanceof�ؼ���
 *
 * 1.�����ж�һ�������Ƿ�Ϊһ�����ʵ��
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
