package pac02_Advance;

import pac01_Basics.Annotation01;
import pac01_Basics.Annotation02;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 * @author TFC
 * @date   2019��8��10�� ����1:49:41
 * @note   �����ȡע��
 */
public class T04_Annotation_Reflection {
	public static void main(String[] args) throws NoSuchFieldException, SecurityException {
		try {
			//1.��ȡ�������ע��
			Class c=Class.forName("bean.Student");
			Annotation[] an=c.getAnnotations();
			for(Annotation a: an) {
				System.out.println(a);
			}
			
			//2.��ȡ���ָ����ע��
			Annotation01 a1=(Annotation01) c.getAnnotation(Annotation01.class);
			System.out.println(a1.value());
			
			//3.��ȡ������Ե�ע��
			Field f=c.getDeclaredField("name");
			Annotation02 a2=f.getAnnotation(Annotation02.class);
			System.out.println(a2.columnName()+"/"+a2.type()+"/"+a2.length());
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
