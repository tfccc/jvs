package pac02_Advance;

import java.lang.annotation.Annotation;

/**
 * @author TFC
 * @date   2019年8月6日 下午5:23:50
 * @note   注解
 * 
 * 1.和一般的注释不同,注解可被编译器识别,并具有一定的语法限定和规范作用
 * 2.关键字:(@interface)
 * 
 * 常见的注解：
 * 1.Override			重写
 * 2.Overload			重载
 * 3.Deprecated			废弃
 * 4.SuppressWarnings	抑制警告
 */
public class T02_Annotation {
	public static void main(String[] args) {

	}
	
	/*1.Override在这里告诉编译器以下方法必须为父类的重写,
	 *如果父类不存在下面的方法名,则不符合注解的规范,编译错误*/
	@Override	
	public String toString() { return null; }
	
	/*2.Deprecated修饰的方法*/
	@Deprecated
	public void Deprecated() {}
	
	/*3.自定义注解*/
	
}
