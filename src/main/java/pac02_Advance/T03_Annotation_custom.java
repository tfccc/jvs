package pac02_Advance;

import pac01_Basics.Annotation01;

/**
 * @author TFC
 * @date   2019年8月10日 下午12:10:04
 * @note   自定义注解测试(Annotation01)
 * 
 * 元注解(用于修饰注解的注解):
 * 1.@Target(描述作用域)
 *	(a)Type			 (类,接口,枚举)
 *	(b)Constructor	 (构造器)
 *	(c)Field		 (描述域)
 *	(d)Method		 (方法)
 *	(e)Local_Variable(局部变量)
 *	(f)Parameter	 (参数)
 *	(g)Package		 (包)
 *
 * 2.@Retention(保留注解信息,描述注解的生命周期)
 *  (a)source		(在源文件中有效)
 *	(b)class		(在class文件中有效)
 *	(c)Field		(在运行时有效,可通过反射读取)
 *
 * 3.@Documented
 * 
 * 4.@Inherited
 * 
 */
@Annotation01(value = { "" })
public class T03_Annotation_custom {

	public static void main(String[] args) {
		
	}
}

