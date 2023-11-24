package pac01_Basics;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author TFC
 * @date   2019年8月10日 下午1:42:06
 * @note   自定义注解02 (src/JavBean/Student.java)
 * 
 * 步骤:
 *	 1.定义注解
 *	 2.类里面使用注解
 *	 3.用解析程序进行处理
 * 
 */

@Target ({ElementType.FIELD, ElementType.TYPE})
@Retention (RetentionPolicy.RUNTIME)
public @interface Annotation02 {
	String columnName();
	String type();
	int length();
}
