package pac02_Advance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author TFC
 * @date 2019��8��12�� ����11:22:56
 * @note ����01: Class��̬��ȡ����,��һЩ����
 *
 * һ.����Ĺ��ܼ�����
 *   ������״̬��,��������һ����,���ܹ�֪���������������Ժ�
 *   ����;��������һ������,���ܹ�������������һ������������
 *
 * ��.�������
 *	 1.���ֻ�ȡ��ķ�ʽ
 *	 2.��ȡ��ľ�����Ϣ
 *	 3.������ù�������������
 *	 4.���������ķ���
 *	 5.�����������
 *
 */
public class T05_Reflection {
    static String path = "bean.Student";

    public static void main(String[] args) throws Exception {
        /**1.���ֻ�ȡ��ķ�ʽ*/
        Class<?> c1 = Class.forName(path);
        Class<?> c2 = Student.class;
        Class<?> c3 = path.getClass();

        /**2.��ȡ��ľ�����Ϣ*/
        //a.��ȡ���������field
        Field[] fields = c1.getDeclaredFields();
		/*for(Field f:fields) 
			System.out.println("����"+f);*/

        /**b.��ȡ����ķ���Method*/
        Method[] methods = c1.getDeclaredMethods();
        Method method1 = c1.getDeclaredMethod("setName", String.class);
		/*for(Method m:methods) 
			System.out.println("����"+m);
		System.out.println(method1);*/

        //c.��ȡ������
        Constructor<?> cons = c1.getConstructor(String.class, int.class);
        //System.out.println(cons);

        /**3.������ù�����,��������*/
        /* �Ƽ����� */
        /* Student stus=(Student)c1.getConstructor().newInstance(); */
        Student stu1 = (Student) cons.newInstance("tfc", 18);

        /**4.���������ķ���*/
        Student stu2 = (Student) c1.newInstance();
        Method met = c1.getDeclaredMethod("setName", String.class);
        met.invoke(stu2, "tfc2...");
        //System.out.println(stu2.getName());

        /**5.�����������*/
        Student stu3 = (Student) c1.newInstance();
        Field f2 = c1.getDeclaredField("age");
        f2.setAccessible(true); //�������Ȩ�ް�ȫ���(private��)(����������)
        f2.set(stu3, 999);
        //System.out.println(stu3.getAge());

    }
}
