package pac02_Advance;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author TFC
 * @date 2019年8月12日 上午11:22:56
 * @note 反射01: Class动态获取对象,及一些操作
 *
 * 一.反射的功能及定义
 *   在运行状态中,对于任意一个类,都能够知道这个类的所有属性和
 *   方法;对于任意一个对象,都能够调用它的任意一个方法和属性
 *
 * 二.反射操作
 *	 1.三种获取类的方式
 *	 2.获取类的具体信息
 *	 3.反射调用构造器构建对象
 *	 4.反射调用类的方法
 *	 5.反射操作属性
 *
 */
public class T05_Reflection {
    static String path = "bean.Student";

    public static void main(String[] args) throws Exception {
        /**1.三种获取类的方式*/
        Class<?> c1 = Class.forName(path);
        Class<?> c2 = Student.class;
        Class<?> c3 = path.getClass();

        /**2.获取类的具体信息*/
        //a.获取定义的属性field
        Field[] fields = c1.getDeclaredFields();
		/*for(Field f:fields) 
			System.out.println("属性"+f);*/

        /**b.获取定义的方法Method*/
        Method[] methods = c1.getDeclaredMethods();
        Method method1 = c1.getDeclaredMethod("setName", String.class);
		/*for(Method m:methods) 
			System.out.println("方法"+m);
		System.out.println(method1);*/

        //c.获取构造器
        Constructor<?> cons = c1.getConstructor(String.class, int.class);
        //System.out.println(cons);

        /**3.反射调用构造器,构建对象*/
        /* 推荐方法 */
        /* Student stus=(Student)c1.getConstructor().newInstance(); */
        Student stu1 = (Student) cons.newInstance("tfc", 18);

        /**4.反射调用类的方法*/
        Student stu2 = (Student) c1.newInstance();
        Method met = c1.getDeclaredMethod("setName", String.class);
        met.invoke(stu2, "tfc2...");
        //System.out.println(stu2.getName());

        /**5.反射操作属性*/
        Student stu3 = (Student) c1.newInstance();
        Field f2 = c1.getDeclaredField("age");
        f2.setAccessible(true); //解除访问权限安全检查(private等)(亦可提高性能)
        f2.set(stu3, 999);
        //System.out.println(stu3.getAge());

    }
}
