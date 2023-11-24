package pac02_Advance;

import pac01_Basics.Annotation01;
import pac01_Basics.Annotation02;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author TFC
 * @date   2019年8月10日 下午1:49:41
 * @note   反射读取注解
 */
public class T04_Annotation_Reflection {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		try {
			//1.获取类的所有注解
			Class c=Class.forName("bean.Student");
			Annotation[] an=c.getAnnotations();
			for(Annotation a: an) {
				System.out.println(a);
			}
			
			//2.获取类的指定的注解
			Annotation01 a1=(Annotation01) c.getAnnotation(Annotation01.class);
			System.out.println(a1.value());
			
			//3.获取类的属性的注解
			Field f=c.getDeclaredField("name");
			Annotation02 a2=f.getAnnotation(Annotation02.class);
			System.out.println(a2.columnName()+"/"+a2.type()+"/"+a2.length());
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
